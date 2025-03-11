import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final int INF = 1 << 30;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            for (int j = l; j <= r; j++) {
                dp[j] = -1;
            }
        }
        for (int i = Math.min(a, b); i <= n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            if (i >= a && dp[i - a] != -1) {
                dp[i] = Math.min(dp[i], dp[i - a] + 1);
            }
            if (i >= b && dp[i - b] != -1) {
                dp[i] = Math.min(dp[i], dp[i - b] + 1);
            }
        }
        System.out.println(dp[n] == INF ? -1 : dp[n]);
        br.close();
    }
}
