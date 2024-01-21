import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[m + 1];
        for (int good = 0; good < n; good++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int tmp = 0;
            while (k >= (1 << tmp)) {
                k -= (1 << tmp++);
            }
            int weight = w;
            int cost = c;
            for (int i = 0; i < tmp; i++) {
                weight = w * (1 << i);
                cost = c * (1 << i);
                for (int j = m; j >= weight; j--) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + cost);
                }
            }
            if (k != 0) {
                w *= k;
                c *= k;
                for (int i = m; i >= w; i--) {
                    dp[i] = Math.max(dp[i], dp[i - w] + c);
                }
            }

        }
        System.out.println(dp[m]);
        br.close();
    }
}
