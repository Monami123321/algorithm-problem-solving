import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long[] dp = new long[n];
        arr[0] = dp[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            dp[i] = dp[i - 1] + arr[i];
        }
        long ans = 0;

        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (dp[n - 1] << 1) - arr[0] - arr[i] - dp[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, dp[i] - arr[0] + dp[n - 1] - arr[n - 1] - dp[i - 1]);
        }
        for (int i = n - 2; i > 0; i--) {
            ans = Math.max(ans, dp[n - 1] - arr[n - 1] - arr[i] + dp[i - 1]);
        }
        System.out.println(ans);
        br.close();
    }
}
