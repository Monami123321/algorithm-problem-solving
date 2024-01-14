import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];


        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), ".*XDS", true);
            for (int j = 0; j < C; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'S') {
                    queue1.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                    continue;
                }
                if (map[i][j] == '*') {
                    queue2.add(new int[]{i, j, 0});
                }
            }
        }
        int t = 0;
        int ans = Integer.MAX_VALUE;
        outer:
        while (!queue1.isEmpty()) {
            while (!queue2.isEmpty() && queue2.peek()[2] == t) {
                int[] now = queue2.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || map[nr][nc] == '*' || map[nr][nc] == 'X' || map[nr][nc] == 'D') {
                        continue;
                    }
                    queue2.add(new int[]{nr, nc, now[2] + 1});
                    map[nr][nc] = '*';

                }
            }
            while (!queue1.isEmpty() && queue1.peek()[2] == t) {
                int[] now = queue1.poll();
                if (map[now[0]][now[1]] == 'D') {
                    ans = now[2];
                    break outer;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || visited[nr][nc] || map[nr][nc] == '*' || map[nr][nc] == 'X') {
                        continue;
                    }
                    queue1.add(new int[]{nr, nc, now[2] + 1});
                    visited[nr][nc] = true;
                }
            }
            t++;
        }
        if (ans == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(ans);
        }
        br.close();
    }
}
