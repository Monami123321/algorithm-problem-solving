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
        long end = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (end < arr[i]) {
                end = arr[i];
            }
        }
        end *= n;

        long start = 0;
        loop:while (end >= start) {
            long mid = (end + start) >> 1;
            int cnt = m;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > mid) {
                    cnt--;
                    sum = 0;
                    i--;
                }
                if (cnt == 0) {
                    start = mid + 1;
                    continue loop;
                }
            }
            end = mid - 1;
        }
        System.out.println(start);
        br.close();
    }
}
