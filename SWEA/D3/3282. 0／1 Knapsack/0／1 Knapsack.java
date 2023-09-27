import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] vol = new int[n + 1];
			int[] cost = new int[n + 1];
			int[][] dp = new int[n + 1][k + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				vol[i] = v;
				cost[i] = c;

			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < k + 1; j++) {
					if (vol[i] <= j) {
						dp[i][j] = Math.max(cost[i] + dp[i - 1][j - vol[i]], dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];

					}

				}

			}

			System.out.printf("#%d %d\n", tc, dp[n][k]);

		}

		br.close();
	}

}
