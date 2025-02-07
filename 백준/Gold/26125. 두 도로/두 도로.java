import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final long INF = 1L << 40;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = INF;
            }
            dp[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (dp[a][b] > c) {
                dp[a][b] = c;
            }
        }
        for (int mid = 1; mid <= n; mid++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (dp[s][e] > dp[s][mid] + dp[mid][e]) {
                        dp[s][e] = dp[s][mid] + dp[mid][e];
                    }
                }
            }
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long ans = dp[start][end];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            ans = Math.min(ans, dp[start][a] + c + dp[b][end]);
            ans = Math.min(ans, dp[start][d] + f + dp[e][end]);
            ans = Math.min(ans, dp[start][d] + f + dp[e][a] + c + dp[b][end]);
            ans = Math.min(ans, dp[start][a] + c + dp[b][d] + f + dp[e][end]);
            sb.append(ans >= INF ? -1 : ans).append("\n");
            ans = dp[start][end];
        }
        System.out.print(sb);
        br.close();
    }
}

