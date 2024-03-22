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

        int[] arr = new int[n];
        int end = 0;
        for (int i = 0; i < n; i++) {
            end += arr[i] = Integer.parseInt(br.readLine());
        }
        int start = 0;
       outer: while (end >= start) {
            int mid = (start + end) / 2;
            int now = mid;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (now >= arr[i]) {
                    now -= arr[i];
                    continue;
                }
                int left = arr[i];
                if (left > mid) {
                    start = mid + 1;
                    continue outer;
                }
                while (left > 0) {
                    cnt++;
                    left -= mid;
                    if (cnt > m) {
                        start = mid + 1;
                        continue outer;
                    }
                }
                now = -left;
            }
           end = mid - 1;
        }
        System.out.println(start);
        br.close();
    }
}
