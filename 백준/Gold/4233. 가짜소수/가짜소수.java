import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            long p = Integer.parseInt(st.nextToken());
            if (p == 0) {
                break;
            }
            long a = Integer.parseInt(st.nextToken());
            if (isPrime(p)) {
                sb.append("no\n");
                continue;
            }
            if (getMod(a, p, p) == a) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static long getMod(long base, long exp, long mod) {
        if (exp == 1) {
            return base % mod;
        }
        long half = getMod(base, exp >> 1, mod);
        if ((exp & 1) == 0) {
            return half * half % mod;
        } else {
            return ((half * half % mod) * base) % mod;
        }
    }

    static boolean isPrime(long n) {
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
}
