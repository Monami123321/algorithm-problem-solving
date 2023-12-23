import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, ans;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ans = -1;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[2][k + 1][n][m];
        queue.add(new int[]{0, 0, 0, 0, 1}); // {r,c,skill,sun,time}
        visited[0][0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int skill = now[2];
            int sun = now[3];
            int time = now[4];

            if (r == n - 1 && c == m - 1) {
                ans = time;
                break;
            }
            if (!visited[sun ^ 1][skill][r][c]) {
                queue.add(new int[]{r, c, skill, sun ^ 1, time + 1});
                visited[sun ^ 1][skill][r][c] = true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nSun = sun ^ 1;

                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    if (sun == 1) {
                        continue;
                    }
                    if (skill == k) {
                        continue;
                    }
                    if (visited[nSun][skill + 1][nr][nc]) {
                        continue;
                    }
                    queue.add(new int[]{nr, nc, skill + 1, nSun, time + 1});
                    visited[nSun][skill + 1][nr][nc] = true;

                } else {
                    if (visited[nSun][skill][nr][nc]) {
                        continue;
                    }
                    queue.add(new int[]{nr, nc, skill, nSun, time + 1});
                    visited[nSun][skill][nr][nc] = true;
                }


            }


        }
        System.out.println(ans);


        br.close();

    }
}
