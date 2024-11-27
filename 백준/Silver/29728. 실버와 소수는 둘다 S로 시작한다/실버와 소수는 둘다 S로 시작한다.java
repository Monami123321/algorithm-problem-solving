import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        int limit = (int) Math.sqrt(n);
        int cnt = 0;
        for (int i = 2; i <= limit; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                cnt++;
                int index = i << 1;
                while (index <= n) {
                    visited[index] = true;
                    index += i;
                }
            }
        }
        for (int i = limit + 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++;
            }
        }
        if (n <= 2) {
            cnt <<= 1;
        } else {
            cnt = (cnt << 1) - 1;
        }

        System.out.printf("%d %d", n - cnt, cnt);
        br.close();
    }

    static boolean isPrime(int n) {
        if (n < 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if ((n & 1) == 0 || n % 3 == 0) {
            return false;
        }
        int limit = (int) Math.sqrt(n);

        for (int i = 5; i <= limit; i += 5) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
