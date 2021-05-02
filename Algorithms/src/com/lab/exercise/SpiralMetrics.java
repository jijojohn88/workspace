package com.lab.exercise;

import java.util.Random;

public class SpiralMetrics {

	public static final int SQUARE_SIZE = 3;
	public boolean[][] seen = new boolean[SQUARE_SIZE][SQUARE_SIZE];

	public void printMetricsRegularly(int[][] metrics) {

		for (int[] row : metrics) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println("");
		}
	}

	public void fillMetrics(int[][] metrics) {
		Random rand = new Random();
		for (int i = 0; i < SQUARE_SIZE; i++) {
			for (int j = 0; j < SQUARE_SIZE; j++) {
				metrics[i][j] = rand.nextInt(10);
			}
		}
	}

	public void printSpiral(int[][] metrics, int x, int y, int layer, String direction) {

		System.out.println("[" + x + "," + y + "]-layer=" + layer);
		if (layer >= SQUARE_SIZE / 2) {
			if (seen[y][x] == false) {
				System.out.print(metrics[y][x] + ",");
			}
			return;
		} else if (direction.equals("RIGHT")) {
			while (x < (SQUARE_SIZE - 1 - layer)) {
				System.out.print(metrics[y][x] + ",");
				seen[y][x]=true;
				x++;
			}
			printSpiral(metrics, x, y, layer, "DOWN");
		} else if (direction.equals("DOWN")) {
			while (y < (SQUARE_SIZE - 1 - layer)) {
				System.out.print(metrics[y][x] + ",");
				seen[y][x]=true;
				y++;
			}
			printSpiral(metrics, x, y, layer, "LEFT");
			y--;
		} else if (direction.equals("LEFT")) {
			while (x > (layer)) {
				System.out.print(metrics[y][x] + ",");
				seen[y][x]=true;
				x--;
			}
			printSpiral(metrics, x, y, layer, "UP");

		} else if (direction.equals("UP")) {
			while (y > (layer)) {
				System.out.print(metrics[y][x] + ",");
				seen[y][x]=true;
				y--;
			}
			layer++;
			printSpiral(metrics, layer, layer, layer, "RIGHT");
		}

	}

	public static void main(String[] args) {

		int[][] metrics = new int[SQUARE_SIZE][SQUARE_SIZE];
		SpiralMetrics spiralMetrics = new SpiralMetrics();
		spiralMetrics.fillMetrics(metrics);
		spiralMetrics.printMetricsRegularly(metrics);

		System.out.println("------------------");

		spiralMetrics.printSpiral(metrics, 0, 0, 0, "RIGHT");

	}
}