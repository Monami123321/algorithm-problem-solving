import java.util.Scanner;

public class Solution {
	static int n;
	static int ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(boolean[][] visited, int r, int c) {

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {	
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc]) {
				continue;
			}
			dfs(visited, nr, nc);

		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testCases = scanner.nextInt();

		for (int tc = 1; tc <= testCases; tc++) {
			n = scanner.nextInt();

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = scanner.nextInt();

				}

			}
			ans = 1;

			int day = 0;

			for (int i = 1; i <= 100; i++) {
				day++;
				int dayAns = 0;
				boolean[][] visited = new boolean[n][n];
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						if (map[j][k] <= day)
							visited[j][k] = true;

					}

				}

				for (int j = 0; j < n; j++) {
					for (int k = 0; k < n; k++) {
						if (visited[j][k])
							continue;
						dayAns++;
						dfs(visited, j, k);

					}

				}
				ans = Math.max(ans, dayAns);

			}

			System.out.printf("#%d %d\n", tc, ans);

		}

		scanner.close();

	}

}
