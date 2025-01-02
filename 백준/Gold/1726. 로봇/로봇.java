import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;
        int startDir = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int endR = Integer.parseInt(st.nextToken()) - 1;
        int endC = Integer.parseInt(st.nextToken()) - 1;
        int endDir = Integer.parseInt(st.nextToken()) - 1;

        Queue<int[]> q = new ArrayDeque<>();
        int[][][] visited = new int[n][m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        q.add(new int[]{startR, startC, startDir, 0});
        visited[startR][startC][startDir] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int d = now[2];
            int t = now[3];


            for (int i = 1; i <= 3; i++) {
                int nr = r + dr[d] * i;
                int nc = c + dc[d] * i;
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || visited[nr][nc][d] <= t + 1) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    break;
                }

                q.add(new int[]{nr, nc, d, t + 1});
                visited[nr][nc][d] = t + 1;
            }
            int nd = d < 2 ? 2 : 0;
            for (int i = 0; i < 2; i++) {
                nd += i;
                if (visited[r][c][nd] > t + 1) {
                    q.add(new int[]{r, c, nd, t + 1});
                    visited[r][c][nd] = t + 1;
                }
            }
        }
        System.out.println(visited[endR][endC][endDir]);
        br.close();
    }
}
