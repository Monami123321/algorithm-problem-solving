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
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long start = 1L;
        long end = Long.MAX_VALUE;

        while (start <= end) {
            long mid = start + ((end - start) >> 1);
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += mid / arr[i];
                if (cnt >= m) {
                    break;
                }
            }
            if (m <= cnt) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);

        br.close();
    }

}
