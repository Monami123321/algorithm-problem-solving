import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = i;
        }
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            if (arr[i][1] > m) {
                continue;
            }
            int a = arr[i][0];
            int b = arr[i][1];
            int c = arr[i][2];
            dp[b] = Math.min(dp[b], dp[a] + c);
            for (int j = b + 1; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1] + 1);
            }
        }
        System.out.println(dp[m]);
        br.close();
    }
}

