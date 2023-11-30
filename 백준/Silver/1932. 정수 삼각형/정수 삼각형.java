import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 삼각형 입력 끝

        int[][] dp = new int[n + 1][n + 1];

        for (int j = 1; j < n + 1; j++) {
            for (int i = 1; i < n + 1; i++) {
                dp[i][j] = Math.max(dp[i - 1][j] + triangle[i - 1][j - 1], dp[i - 1][j - 1] + triangle[i - 1][j - 1]);

            }

        }
        int ans = Arrays.stream(dp[n]).max().getAsInt();
        System.out.println(ans);


    }
}
