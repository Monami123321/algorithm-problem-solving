import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m + 1];
        int INF = 1 << 29;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            for (int j = m; j >= v; j--) {
                dp[j] = Math.min(dp[j], dp[j - v] + 1);
            }
        }
        System.out.println(dp[m] == INF ? -1 : dp[m]);
        br.close();
    }
}
