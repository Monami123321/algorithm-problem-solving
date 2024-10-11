import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int INF = 1 << 28;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dist = new int[n + 1][n + 1];
        int[][] route = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (dist[a][b] > c) {
                dist[a][b] = c;
                route[a][b] = a;
            }
        }
        for (int mid = 1; mid < n + 1; mid++) {
            for (int s = 1; s < n + 1; s++) {
                for (int e = 1; e < n + 1; e++) {
                    if (dist[s][e] > dist[s][mid] + dist[mid][e]) {
                        dist[s][e] = dist[s][mid] + dist[mid][e];
                        route[s][e] = route[mid][e];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] == INF) {
                    dist[i][j] = 0;
                }
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (dist[i][j] == 0) {
                    sb.append(0);
                } else {
                    stack.add(j);
                    int now = route[i][j];
                    while (now != i) {
                        stack.add(now);
                        now = route[i][now];
                    }
                    stack.add(i);
                    sb.append(stack.size()).append(" ");
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop()).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
