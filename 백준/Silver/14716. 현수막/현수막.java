import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }

    static void bfs(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || map[nr][nc] == 0) {
                    continue;
                }
                q.add(new int[]{nr, nc});
                map[nr][nc] = 0;
            }
        }
    }
}
