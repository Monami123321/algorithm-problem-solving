import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int end = 0;
        int index = 0;
        while (index < n) {
            int[] now = arr[index];
            if (end >= now[1]) {
                index++;
                continue;
            }

            if (end >= now[0]) {
                int req = getReqNum(l, end + 1, now[1]);
                end += (req * l);
                ans += req;
                index++;
            } else {
                int req = getReqNum(l, now[0], now[1]);
                end = now[0] - 1 + (req * l);
                ans += req;
                index++;
            }
        }
        System.out.println(ans);
        br.close();
    }

    static int getReqNum(int l, int start, int end) {
        return (end - start) % l == 0 ? (end - start) / l : (end - start) / l + 1;
    }
}
