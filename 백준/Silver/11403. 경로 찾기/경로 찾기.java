import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] dp = new boolean[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (st.nextToken().equals("1")) {
                    dp[i][j] = true;
                }
            }
        }
        for (int m = 0; m < n; m++) {
            for (int s = 0; s < n; s++) {
                for (int e = 0; e < n; e++) {
                    if (!dp[s][e]) {
                        dp[s][e] = dp[s][m] && dp[m][e];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
