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
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            int m = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    m = Math.max(m, dp[j]);
                }
            }
            dp[i] += m;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
        br.close();
    }
}
