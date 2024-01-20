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
        int k = Integer.parseInt(st.nextToken());
        long[] damages = new long[n];
        for (int i = 0; i < n; i++) {
            damages[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(damages);
        int[][] dp = new int[m][901];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            long hp = Long.parseLong(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                if (hp > damages[n - 1 - j] * 900) {
                    continue;
                }
                int time = (int)(hp / damages[n - 1 - j]);
                if (hp % damages[n - 1 - j] != 0) {
                    time++;
                }
                for (int l = 900; l >= time; l--) {
                    dp[j][l] = Math.max(dp[j][l], dp[j][l - time] + money);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += dp[i][900];
        }
        System.out.println(sum);
        br.close();
    }



}