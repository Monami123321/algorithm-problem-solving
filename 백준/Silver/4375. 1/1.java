import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String tmp = br.readLine();
            if (tmp == null) {
                break;
            }
            int n = Integer.parseInt(tmp);
            int r = 10 % n;
            int one = 1 % n;
            int now = 1 % n;
            int cnt = 1;
            while (now != 0) {
                cnt++;
                now = ((r * now) + one) % n;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
