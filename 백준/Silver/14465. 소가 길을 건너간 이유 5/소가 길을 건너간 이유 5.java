import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }
        int start = 1;
        int end = k;
        int now = 0;
        for (int i = start; i <= k; i++) {
            if (arr[i]) {
                now++;
            }
        }
        int cnt = now;
        while (end < n) {
            if (arr[start++]) {
                now--;
            }
            if (arr[++end]) {
                now++;
            }
            cnt = Math.min(cnt, now);
        }
        System.out.println(cnt);
        br.close();
    }
}
