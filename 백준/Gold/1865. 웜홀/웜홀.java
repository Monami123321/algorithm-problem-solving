import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        int INF = 1 << 26;
        for (int tc = 0; tc < testCases; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            int[][] dist = new int[n + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                if (dist[s][e] > t) {
                    dist[s][e] = t;
                }
                if (dist[e][s] > t) {
                    dist[e][s] = t;
                }
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = -Integer.parseInt(st.nextToken());
                if (dist[s][e] > t) {
                    dist[s][e] = t;
                }
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

            boolean flag = false;
            for (int i = 1; i < n + 1; i++) {
                if (dist[i][i] < 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }


        }
        System.out.print(sb);

        br.close();
    }
}
