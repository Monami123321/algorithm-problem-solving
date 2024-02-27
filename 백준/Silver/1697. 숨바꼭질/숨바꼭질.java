import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k <= n) {
            System.out.println(n - k);
            return;
        }
        int[] dp = new int[k + 1];
        int t = 0;
        for (int i = n; i >= 0; i--) {
            dp[i] = t++;
        }
        t = 1;
        for (int i = n + 1; i < k + 1; i++) {
            dp[i] = t++;
        }

        for (int i = n + 1; i < k + 1; i++) {
            if ((i & 1) == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            } else {
                dp[i] = Math.min(Math.min(dp[i], dp[(i + 1) / 2] + 2), dp[(i - 1) / 2] + 2);
            }
        }
        System.out.println(dp[k]);
        br.close();
    }
}
