import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        int limit = (int) Math.sqrt(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= limit; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                if (isValid(i)) {
                    sb.append(i).append("\n");
                }
                int index = i << 1;
                while (index <= n) {
                    visited[index] = true;
                    index += i;
                }
            }
        }
        for (int i = limit + 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (isValid(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static boolean isPrime(int n) {
        if (n < 4) {
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

    static boolean isValid(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int tmp = n % 10;
            int val = tmp * tmp;
            while (n > 0) {
                n /= 10;
                tmp = n % 10;
                val += tmp * tmp;
            }
            if (val == 1) {
                return true;
            }
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
            n = val;
        }
    }
}
