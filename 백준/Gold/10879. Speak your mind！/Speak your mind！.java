import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[1 << 17];
    static {
        dp[0] = 6;
        dp[1] = 1;
        for (int i = 2, num = 2; i < dp.length; i <<= 1) {
            dp[i] = num++;
        }
        for (int i = 3; i < 50001; i++) {
            if (dp[i] != 0) {
                continue;
            }
            int index = 1;
            while (1 << index < i) {
                index++;
            }
            dp[i] = Math.min(dp[1 << index] + dp[(1 << index) - i] + 4, dp[1 << index - 1] + dp[i - (1 << index - 1)] + 4);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Math.abs(Integer.parseInt(br.readLine()));
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
