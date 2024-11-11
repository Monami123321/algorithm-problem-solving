import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[][] lis = new int[2][n];
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[1][i] = lis[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(lis[0], arr[i]);
            if (index < 0) {
                index = -index - 1;
            }
            lis[0][index] = arr[i];
            dp[0][i] = index;
            index = Arrays.binarySearch(lis[1], arr[n - 1 - i]);
            if (index < 0) {
                index = -index - 1;
            }
            lis[1][index] = arr[n - 1 - i];
            dp[1][n - 1 - i] = index;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[0][i] + dp[1][i]);
        }
        System.out.println(ans + 1);
        br.close();
    }
}
