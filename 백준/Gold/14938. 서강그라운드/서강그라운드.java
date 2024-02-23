import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dist = new int[n + 1][n + 1];
        int INF = 1 << 28;
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[a][b] = cost;
            dist[b][a] = cost;
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
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] <= m) {
                    sum += items[j];
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
        br.close();
    }

}