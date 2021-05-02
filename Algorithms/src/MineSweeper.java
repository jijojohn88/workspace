

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

	public static final int MAX_X = 10;
	public static final int MAX_Y = 10;
	public static Cell[][] MOTHER_BOARD = new Cell[MAX_X][MAX_Y];

	public static final int MAX_NUMBER_OF_MINES = 30;

	public void fillBoard() {

		for (int i = 0; i < MAX_X; i++) {

			for (int j = 0; j < MAX_Y; j++) {
				Cell dummyCell = new Cell();
				dummyCell.x = i;
				dummyCell.y = j;
				dummyCell.isRevealed = false;
				MOTHER_BOARD[i][j] = dummyCell;
			}

		}
	}

	public void installMines(int count) {

		Random r = new Random();

		for (int i = 0; i < count; i++) {

			int x = r.nextInt(MAX_X);
			int y = r.nextInt(MAX_X);

			Cell c = MOTHER_BOARD[x][y];

			if (c != null) {
				c.isMine = true;
			}

		}
	}

	public void installNumbers() {
		for (int i = 0; i < MAX_X; i++) {
			for (int j = 0; j < MAX_Y; j++) {

				List<Cell> neighbors = getNeighbors(i, j);
				for (Cell neighbor : neighbors) {
					if (neighbor.isMine) {
						MOTHER_BOARD[i][j].value += 1;
					}
				}

			}
		}
	}

	public void printBoard() {

		for (Cell[] a : MOTHER_BOARD) {
			for (Cell b : a) {
				if (!b.isRevealed) {
					System.out.print("X ");
				} else if (b.isMine) {
					System.out.print("$ ");
				} else {
					System.out.print(b.value + " ");
				}
			}
			System.out.println();
		}

		System.out.println("-----------------------");
	}

	public List<Cell> getNeighbors(int x, int y) {

		List<Cell> neighborList = new ArrayList<Cell>();
		for (int i = -1 + x; i <= x + 1; i++) {
			for (int j = -1 + y; j <= y + 1; j++) {

				if (i > -1 && j > -1 && i < 10 && j < 10 && (!(i == x && j == y))) {
					Cell neighbor = MOTHER_BOARD[i][j];
					neighborList.add(neighbor);
				}

			}
		}
		return neighborList;
	}

	public void randomFillBoard() {
		Random rand = new Random(); // instance of random class
		// generate random values from 0-24
		for (int i = 0; i < MAX_X; i++) {
			for (int j = 0; j < MAX_Y; j++) {
				Cell c = new Cell();
				c.x = i;
				c.y = j;
				c.value = rand.nextInt(10);
				MOTHER_BOARD[i][j] = c;
			}
		}
	}

	public void revealAutomatic(int x, int y) {
		List<Cell> neighbors = getNeighbors(x, y);
		for (Cell c : neighbors) {
			if (!c.isMine && !c.isRevealed) {
				c.isRevealed = true;
				if (c.value == 0) {
					revealAutomatic(c.x, c.y);
				}
			}
		}
	}

	public void reveal(int x, int y) {
		MOTHER_BOARD[x][y].isRevealed = true;
		if (MOTHER_BOARD[x][y].isMine) {
			for (Cell[] cells : MOTHER_BOARD) {
				for (Cell c : cells) {
					c.isRevealed = true;
				}
			}
			printBoard();
			System.out.println("you just hit a Mine and game over");
			System.exit(1);
		} else {
			revealAutomatic(x, y);
		}
	}

	public boolean isGameOver() {
		for (Cell[] cells : MOTHER_BOARD) {
			for (Cell c : cells) {
				if (!c.isMine && !c.isRevealed) {
					return false;
				}
			}
		}
		return true;
	}

	public void revealEverything() {
		for (Cell[] cells : MOTHER_BOARD) {
			for (Cell c : cells) {
				c.isRevealed = true;
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		MineSweeper mineSweeper = new MineSweeper();

		mineSweeper.fillBoard();
		mineSweeper.installMines(MAX_NUMBER_OF_MINES);
		mineSweeper.installNumbers();
		mineSweeper.printBoard();

		Scanner scanner = new Scanner(System.in);
		while (!mineSweeper.isGameOver()) {
			System.out.println("Enter the position to reveal");
			System.out.print("x=");
			int x = scanner.nextInt();
			System.out.print("y=");
			int y = scanner.nextInt();
			mineSweeper.reveal(x, y);
			mineSweeper.printBoard();
		}
		mineSweeper.revealEverything();
		mineSweeper.printBoard();
		System.out.println("WON");
		scanner.close();

	}
}

class Cell {
	int x, y, value;
	boolean isMine = false;
	boolean isRevealed = false;

	@Override
	public String toString() {
		return "cell = { x = " + x + ",y = " + y + ", value = " + value + ", " + "isMine = " + isMine + ", isReveal = "
				+ isRevealed + "]";
	}
}
