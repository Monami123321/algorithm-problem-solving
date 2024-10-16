import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static byte[] buffer = new byte[8];

    public static void main(String[] args) throws IOException {
        int idx = System.in.read(buffer) - 1;
        int n = buffer[0] - 48;
        for (int i = 1; i < idx; i++) {
            n *= 10;
            n += buffer[i] - 48;
        }
        int limit = (int) Math.sqrt(n) + 2;

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                list.add(i);
                idx = i;
                while (idx <= limit) {
                    visited[idx] = true;
                    idx += i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        idx = 0;
        while (n > 1) {
            int p = list.get(idx++);
            while (n % p == 0) {
                n /= p;
                sb.append(p).append("\n");
            }
            if (isPrime(n)) {
                sb.append(n);
                break;
            }
        }
        System.out.print(sb);
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
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
