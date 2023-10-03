import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 못 풂
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n + 1][3]; // RGB 인덱스 012에 저장, dp[i][j] ㅡ> i에 j를 칠할 때 최소값

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;

		}
		int ans = (dp[n][0] > dp[n][1]) ? (dp[n][1] > dp[n][2]) ? dp[n][2] : dp[n][1]
				: (dp[n][0] < dp[n][2]) ? dp[n][0] : dp[n][2];
		System.out.println(ans);

		br.close();
	}

}
