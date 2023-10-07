import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static void calProfit(int r, int c, boolean[] visited, int depth, int honey) {

		if (honey > limit) {
			return;
		}

		if (depth == m && honey <= limit) {
			int tmp = 0;
			for (int i = 0; i < m; i++) {
				if (visited[i]) {
					tmp += map[r][c + i] * map[r][c + i];
				}

			}
			profit = Math.max(profit, tmp);
			return;

		}

		visited[depth] = true;
		calProfit(r, c, visited, depth + 1, honey + map[r][c + depth]);
		visited[depth] = false;
		calProfit(r, c, visited, depth + 1, honey);

	}

	static int[][] map;
	static int n, m, limit, profit, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCases = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			profit = 0;
			ans = 0;

			map = new int[n][n];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			} // 벌통 입력 끝
				// 채취할 수 있는 꿀벌통 ㅡ> m개에 맞춰 인덱스 조절
			for (int i = 0; i < n; i++) { // 행은 첨부터 끝까지
				for (int j = 0; j < n - m + 1; j++) { // 열은 m개 전까지 딱맞게

					// 첫번 째 일꾼
					calProfit(i, j, new boolean[m], 0, 0);
					int profit1 = profit;
					profit = 0;
					int profit2 = 0;
					// 두 번 째 일꾼
					for (int k = i; k < n; k++) {
						for (int l = 0; l < n - m + 1; l++) {
							if ((i == k && l <= j + m - 1) || (i == k && l + m - 1 >= j)) {
								continue; // 첫번 째 일꾼 두번 쨰 일꾼 안겹치게 조절
							}
							calProfit(k, l, new boolean[m], 0, 0);
							profit2 = Math.max(profit2, profit);
							profit = 0;

						}
					}
					ans = Math.max(ans, profit1 + profit2);

				}

			}

			System.out.printf("#%d %d\n", tc, ans);

		}

		br.close();

	}

}
