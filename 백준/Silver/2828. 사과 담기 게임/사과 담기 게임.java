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
        int k = Integer.parseInt(br.readLine());
        int left = 1;
        int right = m;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int w = Integer.parseInt(br.readLine());
            if (w < left) {
                ans += left - w;
                right -= left - w;
                left = w;
            } else if (w > right) {
                ans += w - right;
                left += w - right;
                right = w;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
