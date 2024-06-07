import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1 << 29);
        dp[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j > n - 1) {
                    break;
                }
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        if (dp[n - 1] == 1 << 29) {
            dp[n - 1] = -1;
        }
        System.out.println(dp[n - 1]);
        br.close();
    }
}
