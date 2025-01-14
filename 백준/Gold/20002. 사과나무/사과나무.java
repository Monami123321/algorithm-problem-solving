import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + map[i][j];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n + 1 - i; j++) {
                for (int k = 1; k <= n + 1 - i; k++) {
                    ans = Math.max(ans, getSum(j, k, i));
                }
            }
        }
        System.out.println(ans);
        br.close();
    }

    static int getSum(int r, int c, int l) {
        return dp[r + l - 1][c + l - 1] - dp[r - 1][c + l - 1] - dp[r + l - 1][c - 1] + dp[r - 1][c - 1];
    }

}