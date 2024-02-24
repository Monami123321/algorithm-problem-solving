import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n + 1][n + 1];
        int INF = 1 << 28;

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < k; i++) {
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

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (dist[a][b] != INF && dist[b][a] == INF) {
                sb.append(-1).append("\n");
            } else if (dist[b][a] != INF && dist[a][b] == INF) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
