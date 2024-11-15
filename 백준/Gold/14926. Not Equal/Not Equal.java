import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[n][n];
        visited[0][n - 1] = visited[n - 1][0] = true;
        StringBuilder sb = new StringBuilder("a1 ");
        int len = ((n * (n - 1)) >> 1) - 1;
        int cnt = 0;
        int now = 0;
        while (cnt < len) {
            for (int i = 0; i < n; i++) {
                if (visited[now][i] || now == i) {
                    continue;
                }
                visited[now][i] = visited[i][now] = true;
                now = i;
                sb.append("a").append(now + 1).append(" ");
                cnt++;
                break;
            }
        }
        sb.append("a1");
        System.out.println(sb);
        br.close();
    }
}
