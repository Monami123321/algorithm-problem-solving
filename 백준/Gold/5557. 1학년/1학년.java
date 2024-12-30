import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[2][21];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][Integer.parseInt(st.nextToken())]++;
        int index = 0;
        for (int i = 2; i < n; i++, index ^= 1) {
            int val = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 21; j++) {
                if (j - val >= 0) {
                    dp[index ^ 1][j - val] += dp[index][j];
                }
                if (j + val < 21) {
                    dp[index ^ 1][j + val] += dp[index][j];
                }
            }
            Arrays.fill(dp[index], 0);
        }
        System.out.println(dp[index][Integer.parseInt(st.nextToken())]);
        br.close();
    }
}
