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
            if (n < 2 ) {
                sb.append(2).append("\n");
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
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
