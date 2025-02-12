import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int cnt = prev << 1;
        for (int i = 1; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            cnt = Math.max(cnt, tmp - prev);
            prev = tmp;
        }
        cnt = Math.max(cnt, (n - prev) << 1);
        System.out.println((cnt & 1) == 0 ? cnt >> 1 : (cnt >> 1) + 1);
        br.close();
    }
}
