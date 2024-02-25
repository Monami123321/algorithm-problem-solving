import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] dist = new int[n][n];
        int[][] arr = new int[n][n];
        int INF = 1 << 28;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = dist[i][j];
            }
        }

        for (int mid = 0; mid < n; mid++) {
            for (int start = 0; start < n; start++) {
                for (int end = 0; end < n; end++) {
                    if (mid == start || mid == end) {
                        continue;
                    }
                    if (dist[start][end] > dist[start][mid] + dist[mid][end]) {
                        System.out.println(-1);
                        return;
                    }
                    if (dist[start][end] == dist[start][mid] + dist[mid][end]) {
                        arr[start][end] = INF;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i][j] == INF) {
                    continue;
                }
                ans += arr[i][j];
            }
        }
        System.out.println(ans);
        br.close();
    }
}
