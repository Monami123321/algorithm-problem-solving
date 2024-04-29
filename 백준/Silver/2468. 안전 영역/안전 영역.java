import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int height = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                height = Math.max(height, map[i][j]);
            }
        }
        int ans = 1;
        for (int h = 1; h < height; h++) {
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] || map[i][j] > h) {
                        continue;
                    }
                    bfs(map, visited, i, j, h, n);
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        cnt++;
                        bfs(map, visited, i, j, Integer.MAX_VALUE, n);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
        br.close();
    }

    static void bfs(int[][] map, boolean[][] visited, int startR, int startC, int h, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc] || map[nr][nc] > h) {
                    continue;
                }
                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
