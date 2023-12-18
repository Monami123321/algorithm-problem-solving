import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][][] visited = new boolean[k+1][n][m];
        int ans = -1;

        pq.add(new int[]{0, 0, 1, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int r = now[0];
            int c = now[1];
            int cost = now[2];
            int wall = now[3];
            if (r == n - 1 && c == m - 1) {
                ans = cost;
                break;

            }
            if (visited[wall][r][c] || wall > k) {
                continue;
            }
            visited[wall][r][c] = true;


            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1) {
                    continue;
                }
                int nextWall = wall;

                if (map[nr][nc] == 1) {
                    nextWall += 1;
                }
                if (nextWall > k || visited[nextWall][nr][nc]) {
                    continue;
                }
                pq.add(new int[]{nr, nc, cost + 1, nextWall});
            }


        }

        System.out.println(ans);


    }
}
