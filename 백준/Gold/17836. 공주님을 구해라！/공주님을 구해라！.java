import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        ans = 1 << 30;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }

        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[2][n][m];
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int time = now[2];
            int skill = now[3];

            if (r == n - 1 && c == m - 1) {
                ans = ans > time ? time : ans;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || (map[nr][nc] == 1 && now[3] == 0)) {
                    continue;
                }

                if (visited[skill][nr][nc]) {
                    continue;
                }

                if (skill == 0 && map[nr][nc] == 2) {
                    queue.add(new int[]{nr, nc, time + 1, skill + 1});
                } else {
                    queue.add(new int[]{nr, nc, time + 1, skill});
                }
                visited[skill][nr][nc] = true;


            }


        }
        if (ans > limit) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }


    }
}
