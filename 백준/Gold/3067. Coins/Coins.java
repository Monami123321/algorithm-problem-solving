import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                for (int j = v; j <= m; j++) {
                    dp[j] += dp[j - v];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
