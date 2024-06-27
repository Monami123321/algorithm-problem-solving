import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            long n = Long.parseLong(br.readLine());
            if (n < 3) {
                sb.append(2).append("\n");
                continue;
            } else if (n == 3) {
                sb.append(3).append("\n");
                continue;
            }
            while (true) {
                if (isPrime(n)) {
                    sb.append(n).append("\n");
                    break;
                } else {
                    ++n;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }

    static boolean isPrime(long n) {
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
