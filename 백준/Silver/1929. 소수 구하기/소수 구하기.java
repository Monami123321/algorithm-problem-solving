import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n + 1];
        visited[0] = visited[1] = true;

        for (int i = m; i < n + 1; i++) {
            if (visited[i])
                continue;
            if (isPrime(i)) {
                sb.append(i).append("\n");
                int next = i * 2;
                while (next <= n) {
                    visited[next] = true;
                    next += i;
                }
            }
        }

        System.out.print(sb);


    }
}
