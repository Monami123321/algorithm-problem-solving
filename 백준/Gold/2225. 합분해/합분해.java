import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000000000;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];
        System.out.println(getVal(n, k));
        br.close();
    }

    static int getVal(int n, int k) {
        if (k == 1 || n == 0) {
            return 1;
        }
        if (dp[n][k] != 0) {
            return dp[n][k];
        }
        return dp[n][k] = (getVal(n, k - 1) + getVal(n - 1, k)) % MOD;
    }
}

