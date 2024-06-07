import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    break;
                }
                int c = j + map[i][j];
                int r = i + map[i][j];
                if (c < n) {
                    dp[i][c] += dp[i][j];
                }
                if (r < n) {
                    dp[r][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
        br.close();

    }
}
