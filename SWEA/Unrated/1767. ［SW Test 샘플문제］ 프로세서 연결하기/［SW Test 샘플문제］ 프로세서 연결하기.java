import java.util.Scanner;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int ans;
	static int n;
	static int core;
	static int[][] map;
	static int[][] coreRC;
	static int connected;
	static int connectedAns;

	static boolean check(int r, int c, int dir) {
		for (int i = 1;; i++) {
			if (r + dr[dir] * i < 0 || r + dr[dir] * i > n - 1 || c + dc[dir] * i < 0 || c + dc[dir] * i > n - 1)
				return true;
			if (map[r + dr[dir] * i][c + dc[dir] * i] == 1 || map[r + dr[dir] * i][c + dc[dir] * i] == -1) {
				return false;
			}
		}

	}

	static void connect(int r, int c, int dir) {
		for (int i = 1;; i++) {
			if (r + dr[dir] * i < 0 || r + dr[dir] * i > n - 1 || c + dc[dir] * i < 0 || c + dc[dir] * i > n - 1)
				return;
			map[r + dr[dir] * i][c + dc[dir] * i] = -1;
		}

	}

	static void reset(int r, int c, int dir) {
		for (int i = 1;; i++) {
			if (r + dr[dir] * i < 0 || r + dr[dir] * i > n - 1 || c + dc[dir] * i < 0 || c + dc[dir] * i > n - 1)
				return;
			map[r + dr[dir] * i][c + dc[dir] * i] = 0;
		}

	}

	static void dfs(int r, int c, int depth) {
		if (connected + core - depth < connectedAns)
			return;
		if (depth == core) {
			if (connected < connectedAns)
				return;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == -1)
						sum++;

				}

			}

			if (connected > connectedAns) {
				ans = sum;
				connectedAns = connected;
				return;
			} else {
				ans = Math.min(ans, sum);
				connectedAns = connected;
				return;
			}

		}

		for (int i = 0; i < 4; i++) {
			if (check(r, c, i)) {
				connect(r, c, i);
				connected++;
				dfs(coreRC[depth + 1][0], coreRC[depth + 1][1], depth + 1);
				connected--;
				reset(r, c, i);

			}
		}
		dfs(coreRC[depth + 1][0], coreRC[depth + 1][1], depth + 1);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();
		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();
			map = new int[n][n];
			core = 0;
			ans = 0;
			connected = 0;
			connectedAns = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = scanner.nextInt();
				}

			}

			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < n - 1; j++) {
					if (map[i][j] == 1)
						core++;
				}

			}
			coreRC = new int[core + 1][2];
			for (int i = 1, index = 0; i < n - 1; i++) {
				for (int j = 1; j < n - 1; j++) {
					if (map[i][j] == 1) {
						coreRC[index][0] = i;
						coreRC[index++][1] = j;
					}

				}

			}

			dfs(coreRC[0][0], coreRC[0][1], 0);
			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();
	}
}