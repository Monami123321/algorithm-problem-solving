import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int now = n;
        while (true) {
            cnt++;
            now = getNextInt(now);
            if (now == n) {
                break;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    static int getNextInt(int a) {
        int res = a % 10;
        int tmp = 0;
        while (a != 0) {
            tmp += a % 10;
            a /= 10;
        }
        return res * 10 + tmp % 10;
    }
}
