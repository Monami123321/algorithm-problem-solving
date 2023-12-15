import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static void borderCheck() {
        queue.add(new int[]{0, 0});
        map[0][0] = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || map[nr][nc] != 0)
                    continue;
                queue.add(new int[]{nr, nc});
                map[nr][nc] = -1;

            }
        }

    }

    static int bfs(int y, int x) {
        int res = 0;
        queue.add(new int[]{y, x});
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (map[nr][nc] == -1) {
                    nextMap[r][c] = 0;
                    res++;
                    break;
                }

            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || visited[nr][nc] || map[nr][nc] <= 0) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;


            }

        }
        return res;

    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map, nextMap;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int R, C, cnt, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        nextMap = new int[R][C];
        visited = new boolean[R][C];
        queue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                nextMap[i][j] = map[i][j];
            }
        }


        t = 0;
        cnt = 0;
        while (true) {
            int tmp = 0;
            borderCheck();
            for (int i = 1; i < R - 1; i++) {
                for (int j = 1; j < C - 1; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    if (map[i][j] < 1) {
                        continue;
                    }
                    tmp += bfs(i, j);
                }
            }
            if (tmp == 0) {
                break;
            }
            t++;
            cnt = tmp;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = nextMap[i][j];
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(t);
        System.out.println(cnt);

    }
}
