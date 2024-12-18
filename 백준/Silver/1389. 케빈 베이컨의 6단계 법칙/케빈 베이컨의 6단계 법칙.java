import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = 1 << 29;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = dist[b][a] = 1;
        }
        for (int mid = 1; mid <=n ; mid++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <=n; e++) {
                    if (dist[s][e] > dist[s][mid] + dist[mid][e]) {
                        dist[s][e] = dist[s][mid] + dist[mid][e];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    continue;
                }
                sum += dist[i][j];
            }
            if (min > sum) {
                min = sum;
                ans = i;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
