import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int ans = 0;
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int r = now[0];
            int c = now[1];
            int diff = now[2];
            ans = Math.max(ans, diff);
            if (r == n - 1 && c == n - 1) {
                break;
            }
            //pq.clear();
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc]) {
                    continue;
                }
                int nextDiff = Math.abs(map[r][c] - map[nr][nc]);
                pq.add(new int[]{nr, nc, nextDiff});
            }
        }

        System.out.println(ans);


    }
}
