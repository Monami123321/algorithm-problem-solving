import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == m) {
                System.out.println(m);
                return;
            }
            if (arr[i] > m) {
                arr[i] = Integer.MAX_VALUE;
            }
        }
        int left = 0;
        while (left < n && arr[left] == Integer.MAX_VALUE) {
            left++;
        }
        int right = left + 1;
        long sum = left == n ? 0 : arr[left];
        long ans = 0;
        while (right < n) {
            if (arr[right] == Integer.MAX_VALUE) {
                ans = Math.max(ans, sum);
                while (right < n && arr[right] == Integer.MAX_VALUE) {
                    right++;
                }
                left = right;
                right++;
                if (left < n) {
                    sum = arr[left];
                }
            } else {
                if (sum + arr[right] > m) {
                    ans = Math.max(ans, sum);
                    sum -= arr[left++];
                } else {
                    sum += arr[right++];
                }
            }
        }
        ans = Math.max(ans, sum);
        System.out.println(ans);
        br.close();
    }
}
