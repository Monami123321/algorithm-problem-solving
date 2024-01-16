import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long gold = 1_000_000_000_002L;
        long silver = 1_000_001L;
        long bronze = 1L;
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = id;
            arr[i][1] = g * gold + s * silver + b * bronze;

        }
        Arrays.sort(arr, (a, b) -> (int) ((b[1] - a[1]) % Integer.MAX_VALUE));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == k) {
                ans = i + 1;
                long val = arr[i][1];
                int next = i - 1;
                while (next >= 0 && arr[next--][1] == val) {
                    ans--;
                }
                break;
            }
        }
        System.out.println(ans);

        br.close();
    }
}
