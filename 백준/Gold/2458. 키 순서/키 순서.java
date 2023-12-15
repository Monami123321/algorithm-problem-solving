import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] dist = new int[n + 1][n + 1];
        int INF = 1 << 29;
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;

        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
        }

        for (int mid = 1; mid < n + 1; mid++) {
            for (int start = 1; start < n + 1; start++) {
                for (int end = 1; end < n + 1; end++) {
                    if (dist[start][end] > dist[start][mid] + dist[mid][end]) {
                        dist[start][end] = dist[start][mid] + dist[mid][end];
                    }
                }
            }
        }


        int cnt = 0;
        outer:
        for (int i = 1; i < n + 1; i++) {
            boolean[] visited = new boolean[n + 1];

            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] != INF) {
                    visited[j] = true;
                }
            }
            for (int j = 1; j < n + 1; j++) {
                if (dist[j][i] != INF) {
                    visited[j] = true;
                }

            }
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j]) {
                    continue outer;
                }
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
