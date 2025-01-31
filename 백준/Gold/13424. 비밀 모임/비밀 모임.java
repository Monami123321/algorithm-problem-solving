import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        final int INF = 1 << 26;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] dist = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                dist[b][a] = dist[a][b] = c;
            }
            for (int mid = 1; mid <= n; mid++) {
                for (int s = 1; s <= n; s++) {
                    for (int e = 1; e <= n; e++) {
                        if (dist[s][e] > dist[s][mid] + dist[mid][e]) {
                            dist[s][e] = dist[s][mid] + dist[mid][e];
                        }
                    }
                }
            }
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int min = Integer.MAX_VALUE;
            int sum;
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += dist[arr[j]][i];
                }
                if (min > sum) {
                    ans = i;
                    min = sum;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
