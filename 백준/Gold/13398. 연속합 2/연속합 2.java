import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] dp = new int[2][n];
        int ans = dp[1][0] = dp[0][0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            dp[0][i] = Math.max(val, dp[0][i - 1] + val);
            dp[1][i] = Math.max(Math.max(val, dp[1][i - 1] + val), dp[0][i - 1]);
            ans = Math.max(Math.max(ans, dp[0][i]), dp[1][i]);
        }
        System.out.println(ans);
        br.close();
    }
}
