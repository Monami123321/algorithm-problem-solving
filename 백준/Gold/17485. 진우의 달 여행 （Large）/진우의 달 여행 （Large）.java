import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 2][m + 2];
		int[][][] dp = new int[n + 2][m + 2][3];
		for (int i = 0; i < n + 2; i++) {
			arr[i][0] = arr[i][m + 1] = 1 << 29;
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 2; i < n + 2; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i - 1][j + 1];
				dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i - 1][j];
				dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i - 1][j - 1];
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < 3; j++) {
				ans = Math.min(dp[n + 1][i][j], ans);
			}
		}
		System.out.println(ans);
		br.close();
	}
}
