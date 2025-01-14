import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 0;
        int tmp;
        while ((tmp = System.in.read()) != -1) {
            if (tmp < 48) {
                break;
            }
            n *= 10;
            n += tmp - 48;
        }
        int ans = n;
        for (int i = 2; i <= n; i++) {
            ans += n / i;
        }
        tmp = 1;
        while (tmp * tmp <= n) {
            ans++;
            tmp++;
        }
        System.out.println(ans >> 1);
    }
}
