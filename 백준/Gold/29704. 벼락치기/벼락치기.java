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
        int[] dp = new int[m + 1];
        int INF = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            INF += arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,INF);
        for (int i = 0; i < n; i++) {
            int w = arr[i][0];
            int v = arr[i][1];
            for (int j = m; j >= w; j--) {
                dp[j] = Math.min(dp[j], dp[j - w] - v);
            }
        }
        System.out.println(dp[m]);
        br.close();
    }
}
