import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        int[] dp = new int[s + 4];
        for (int i = 1; i < s + 4; i++) {
            dp[i] = i; // 1개짜리 복사 -> 계속붙여넣는경우
        }

        for (int i = 2; i < s + 4; i++) {
            int start = dp[i] + 1; // i개 이모티콘을 복사한 경우 고려
            for (int j = i + i, tick = 1; j < s + 3; j += i) {
                dp[j] = Math.min(dp[j], start + tick++);
            }
            for (int j = 3; j < s+3; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1] + 1);
                
            }
        }
        for (int i = 2; i < s + 2; i++) {
            dp[i] = Math.min(dp[i], dp[i + 1] + 1);

        }
        System.out.println(dp[s]);
    }
}
