import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c, val;

        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[][] map = new Node[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = new Node(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        int k = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a.val));
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            pq.add(map[i][0]);
            pq.add(map[i][m - 1]);
        }
        for (int i = 0; i < m; i++) {
            pq.add(map[0][i]);
            pq.add(map[n - 1][i]);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (cnt < k) {
            Node node = pq.poll();
            if (visited[node.r][node.c]) {
                continue;
            }
            visited[node.r][node.c] = true;
            cnt++;
            sb.append(node.r + 1).append(" ").append(node.c + 1).append("\n");
            for (int j = 0; j < 4; j++) {
                int nr = node.r + dr[j];
                int nc = node.c + dc[j];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || visited[nr][nc]) {
                    continue;
                }
                pq.add(map[nr][nc]);
            }
        }
        System.out.print(sb);


        br.close();
    }
}
