import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[1002];
        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                visited[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 1001; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = 1; j <= 1001; j++) {
                if (visited[j]) {
                    continue;
                }
                for (int k = 1; k <= 1001; k++) {
                    if (visited[k]) {
                        continue;
                    }
                    ans = Math.min(ans, Math.abs(i * j * k - n));
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}
