import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int weight = i + 1;
            int value = prices[i];
            int k = n / weight;

            int index = 0;

            while (k >= 1 << index) {
                k -= 1 << index;
                int w = weight * (1 << index);
                int v = value * (1 << index++);

                for (int j = n; j >= w; j--) {
                    dp[j] = Math.max(dp[j - w] + v, dp[j]);
                }
            }
            weight *= k;
            value *= k;
            for (int j = n; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }

        }
        System.out.println(dp[n]);


        br.close();

    }
}
