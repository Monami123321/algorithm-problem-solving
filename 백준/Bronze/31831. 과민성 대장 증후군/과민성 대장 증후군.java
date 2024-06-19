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
        int now = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            now += Integer.parseInt(st.nextToken());
            if (now < 0) {
                now = 0;
            }
            if (now >= m) {
                ++ans;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
