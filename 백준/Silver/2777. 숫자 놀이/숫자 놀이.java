import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                sb.append(1).append("\n");
                continue;
            }
            sb.append(cal(n)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    static int cal(int n) {
        int cnt = 0;
        for (int i = 9; i > 1; --i) {
            while (n % i == 0) {
                ++cnt;
                n /= i;
            }
        }
        if (n != 1) {
            return -1;
        }
        return cnt;
    }
}
