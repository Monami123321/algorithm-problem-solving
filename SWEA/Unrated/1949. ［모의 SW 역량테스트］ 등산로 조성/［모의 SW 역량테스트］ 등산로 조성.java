import java.util.Scanner;

public class Solution {
	static int n;
	static int k;
	static int ans;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int depth, boolean[][] visited, boolean cut) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc]) {
				ans = Math.max(ans, depth);
				continue;
			}

			if (map[nr][nc] < map[r][c]) {
				dfs(nr, nc, depth + 1, visited, cut);
			} else if (cut) {
				if (map[nr][nc] - k < map[r][c]) {
					int tmp = map[nr][nc];
					map[nr][nc] = map[r][c] - 1;
					dfs(nr, nc, depth + 1, visited, false);
					map[nr][nc] = tmp;
				}

			} else {
				ans = Math.max(ans, depth);
				continue;
			}

		}
		visited[r][c] = false;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();
			k = scanner.nextInt();
			map = new int[n][n];
			ans = 0;

			int top = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = scanner.nextInt();
					top = Math.max(top, map[i][j]);
				}

			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == top) {
						dfs(i, j, 1, new boolean[n][n], true);
					}

				}

			}
			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();

	}
}