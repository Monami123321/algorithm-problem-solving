import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long limit = Long.parseLong(br.readLine());
        if (limit < 10) {
            System.out.println(limit);
            return;
        }

        int n = 1;
        int cnt = 9;
        while (true) {
            StringBuilder sb = new StringBuilder();
            long tmp = Long.parseLong(sb.append(n).append(new StringBuilder().append(n).reverse()).toString());
            if (tmp > limit) {
                break;
            }
            cnt++;
            n++;
        }
        n = 1;
        outer:
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(n);
            for (int i = 0; i < 10; i++) {
                long tmp = Long.parseLong(new StringBuilder(sb).append(i).append(new StringBuilder(sb).reverse()).toString());
                if (tmp > limit) {
                    break outer;
                }
                cnt++;
            }
            n++;
        }
        System.out.println(cnt);
        br.close();
    }
}
