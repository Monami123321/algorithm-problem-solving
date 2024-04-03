import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited = new boolean[1001];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i * i <= 1000; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                set.add(i);
                int index = i;
                while (index <= 1000) {
                    visited[index] = true;
                    index += i;
                }
            }
        }
        for (int i = (int)Math.sqrt(1000); i <=1000 ; i++) {
            if (!visited[i]) {
                set.add(i);
            }
        }
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                ++ans;
            }
        }
        System.out.println(ans);
        br.close();
    }
    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
