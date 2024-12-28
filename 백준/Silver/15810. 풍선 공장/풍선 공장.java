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
        long start = 1;
        long end = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, (long) arr[i] * m);
        }
        while (start <= end) {
            long mid = start + end >> 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (int) (mid / arr[i]);
                if (sum >= m) {
                    break;
                }
            }
            if (sum >= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        br.close();
    }
}
