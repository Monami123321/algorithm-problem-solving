import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 1;
        int cnt = 0;
        while (ans < n) {
            ans <<= 1;
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        if (ans == n) {
            sb.append(ans).append(" ").append(0);
        } else {
            int ref = 0;
            while ((n & 1 << ref) == 0) {
                ref++;
            }
            sb.append(ans).append(" ").append(cnt - ref);
        }
        System.out.print(sb);
        br.close();
    }
}
