import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][i] = 1;
            dp[i][1] = i;
        }
        System.out.println(recur(n, k));
        br.close();
    }

    static int recur(int n, int k) {
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        return dp[n][k] = (recur(n - 1, k) + recur(n - 1, k - 1)) % 10007;
    }
}
