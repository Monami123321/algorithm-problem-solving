import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 1;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (st.nextToken().equals("1")) {
                ans += cnt++;
            } else {
                cnt = 1;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
