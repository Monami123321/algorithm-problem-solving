import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
            if (arr[i] == 0) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if ((j & 1) == 0) {
                    if (arr[i] == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    }
                } else {
                    if (arr[i] != 0) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= w; i++) {
            ans = Math.max(dp[n][i], ans);
        }
        System.out.println(ans);
        br.close();
    }
}
