import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int t = 1;
        int k = 10 % n;
        boolean[] visited = new boolean[n];

        while (true) {
            int mod = t % n;
            if (mod == 0) {
                break;
            }
            if (visited[mod]) {
                System.out.println(-1);
                return;
            }
            visited[mod] = true;
            t = ((t % n) * k) % n + 1;
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}
