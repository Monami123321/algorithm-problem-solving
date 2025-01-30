import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[][][] visited;
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][];
        visited = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            bfs(r, c, i);
        }
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int tmp;
        for (int i = 0; i < n; i++) {
            outer:
            for (int j = 0; j < m; j++) {
                tmp = -1;
                for (int k = 0; k < 3; k++) {
                    if (visited[i][j][k] == Integer.MAX_VALUE) {
                        continue outer;
                    }
                    tmp = Math.max(visited[i][j][k], tmp);
                }
                if (min == tmp) {
                    cnt++;
                } else if (min > tmp) {
                    min = tmp;
                    cnt = 1;
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.printf("%d\n%d", min, cnt);
        }
        br.close();
    }

    static void bfs(int startR, int startC, int index) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC, 0});
        visited[startR][startC][index] = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int t = now[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 49 || visited[nr][nc][index] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[]{nr, nc, t + 1});
                visited[nr][nc][index] = t + 1;
            }
        }
    }
}
