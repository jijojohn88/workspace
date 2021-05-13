import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInaGrid {

	int[] dirs = { 0, 1, 0, -1, 0 };

	public int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		boolean[][][] visited = new boolean[m][n][m * n];
		visited[0][0][0] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 0, 0));
		while (!queue.isEmpty()) {
			Node top = queue.poll();
			if (top.r == m - 1 && top.c == n - 1)
				return top.distance; // Found the result
			for (int i = 0; i < 4; i++) {
				int nr = top.r + dirs[i], nc = top.c + dirs[i + 1];
				if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
					int nk = top.k + grid[nr][nc]; // Number of the obstacles elimination so far
					if (nk <= k && !visited[nr][nc][nk]) {
						visited[nr][nc][nk] = true;
						queue.offer(new Node(nr, nc, nk, top.distance + 1));
					}
				}
			}
		}
		return -1; // Not found
	}

	class Node {
		int r, c, k, distance;

		Node(int r, int c, int k, int dist) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.distance = dist;
		}
	}
}
