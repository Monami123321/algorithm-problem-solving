import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int ref = 10;
        while (ref < t) {
            ref *= 10;
        }
        int cnt = 0;
        boolean[] visited = new boolean[e + 1];
        int limit = (int) Math.sqrt(e);
        for (int i = 2; i <= limit; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                int index = i * i;
                while (index <= e) {
                    visited[index] = true;
                    index += i;
                }
                if (i >= s && isValid(i, t, ref)) {
                    cnt++;
                }
            }
        }
        for (int i = limit + 1; i <= e; i++) {
            if (!visited[i] && i >= s && isValid(i, t, ref)) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
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

    static boolean isValid(int n, int t, int ref) {
        while (n > 0) {
            if (n % ref == t) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
