import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int r, c;
        List<Node> switches;

        public Node(int r, int c) {
            this.switches = new ArrayList<>();
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[][] map = new Node[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = new Node(i, j);
            }
        }


        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int switchR = Integer.parseInt(st.nextToken());
            int switchC = Integer.parseInt(st.nextToken());
            map[r][c].switches.add(map[switchR][switchC]);
        }

        boolean[][] check = new boolean[n + 1][n + 1];
        boolean[][] visited = new boolean[n + 1][n + 1];
        check[1][1] = true;
        visited[1][1] = true;

        Queue<Node> queue = new LinkedList<>();

        queue.add(map[1][1]);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            now.switches.forEach(node -> {
                if(visited[node.r][node.c])
                    return;
                check[node.r][node.c] = true;
                for (int i = 0; i < 4; i++) {
                    int nr = node.r + dr[i];
                    int nc = node.c + dc[i];
                    if (nr < 1 || nr > n || nc < 1 || nc > n) {
                        continue;
                    }
                    if (check[nr][nc] && visited[nr][nc]) {
                        queue.add(map[node.r][node.c]);
                        visited[node.r][node.c] = true;
                        return;
                    }

                }
            });

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr < 1 || nr > n || nc < 1 || nc > n || !check[nr][nc] || visited[nr][nc]) {
                    continue;
                }
                queue.add(map[nr][nc]);
                visited[nr][nc] = true;

            }
        }
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (check[i][j])
                    cnt++;
            }
        }
        System.out.println(cnt);

    }
}
