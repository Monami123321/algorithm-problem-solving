import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long lcm = 1L;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (isPrime(now)) {
                lcm = lcm * now / getGCD(lcm, now);
            }
        }
        System.out.println(lcm == 1L ? -1 : lcm);
        br.close();
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if ((n & 1) == 0 || n % 3 == 0) {
            return false;
        }
        int limit = (int) Math.sqrt(n);
        for (int i = 5; i <= limit; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    static long getGCD(long a, long b) {
        long tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
