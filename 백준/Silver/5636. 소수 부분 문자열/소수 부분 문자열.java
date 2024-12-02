import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[100001];
        int limit = (int) Math.sqrt(100001);
        for (int i = 0; i <= limit; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                int index = i << 1;
                while (index <= 100000) {
                    visited[index] = true;
                    index += i;
                }
            } else {
                visited[i] = true;
            }
        }
        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            int strLen = str.length();
            int len = Math.min(str.length(), 6);
            int ans = 0;
            boolean flag = false;
            for (int i = len; i > 0; i--) {
                if (flag) {
                    break;
                }
                for (int j = 0; j <= strLen - i; j++) {
                    String tmp = str.substring(j, j + i);
                    if (tmp.startsWith("0")) {
                        continue;
                    }
                    int n = Integer.parseInt(tmp);
                    if (n > 100000) {
                        continue;
                    }
                    if (!visited[n]) {
                        flag = true;
                        ans = Math.max(ans, n);
                    }
                }
            }
            sb.append(ans).append("\n");
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
