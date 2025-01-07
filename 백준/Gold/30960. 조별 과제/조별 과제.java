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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long[] dp = new long[n];
        dp[2] = arr[2] - arr[0];
        dp[1] = arr[1] - arr[0];
        for (int i = 3; i < n; i ++) {
            if ((i & 1) == 0) {
                dp[i] = Math.min(dp[i - 3] + arr[i] - arr[i - 2], dp[i - 2] + arr[i] - arr[i - 1]);
            } else {
                dp[i] = dp[i - 2] + arr[i] - arr[i - 1];
            }
        }
        System.out.println(dp[n-1]);
        br.close();
    }
}
