import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int left = 1;
        int right = 1;
        long ans = 0;
        while (right < n + 1) {
            if (left > right) {
                right = left;
                if (right > n) {
                    break;
                }
            }
            long sum = arr[right] - arr[left - 1];
            if (sum > target) {
                ans += n + 1 - right;
                left++;
            } else {
                right++;
            }
        }
        System.out.println(ans);

        br.close();
    }
}
