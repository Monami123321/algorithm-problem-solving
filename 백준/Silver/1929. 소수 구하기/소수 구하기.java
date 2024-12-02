import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        int limit = (int) Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                int index = i << 1;
                while (index <= n) {
                    visited[index] = true;
                    index += i;
                }
            } else {
                visited[i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (!visited[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
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
}
