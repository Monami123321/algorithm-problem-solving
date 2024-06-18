import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1 << 28;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int p = Integer.parseInt(st.nextToken());
            for (int j = i; j < n + 1; j++) {
                dp[j] = Math.min(dp[j - i] + p, dp[j]);
            }
        }
        System.out.println(dp[n]);
        br.close();
    }
}
