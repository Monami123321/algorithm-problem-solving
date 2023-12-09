import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }


        }
        return true;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 0;


        boolean[] visited = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (visited[i])
                continue;
            if (isPrime(i)) {
                int multiple = 1;
                while (true) {
                    int now = i * multiple;
                    if (now > n) {
                        break;
                    }
                    if (visited[now]) {
                        multiple++;
                        continue;
                    }
                    visited[now] = true;
                    multiple++;
                    k--;
                    ans = now;
                    if (k == 0) {
                        System.out.println(ans);
                        return;
                    }
                }


            }


        }

    }
}
