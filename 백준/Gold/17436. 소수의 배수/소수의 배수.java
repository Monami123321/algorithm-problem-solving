import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long multiple;
        long ans = 0L;

        for (int i = 1; i < 1 << n; i++) {
            int cnt = Integer.bitCount(i);
            multiple = 1L;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    multiple *= arr[j];
                }
            }
            if ((cnt & 1) == 0) {
                ans -= m / multiple;
            } else {
                ans += m / multiple;
            }
        }
        System.out.println(ans);
        br.close();
    }
}