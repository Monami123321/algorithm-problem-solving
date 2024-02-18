import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> sharks = new ArrayList<>();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(st.nextToken()) != 0) {
                    map[i][j] = -1;
                    sharks.add(new int[]{i, j});
                }
                ;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int[] shark : sharks) {
            queue.add(new int[]{shark[0], shark[1], 0});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int r = now[0];
                int c = now[1];
                int cost = now[2];

                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nr > n - 1 || nc > m - 1 || nc < 0) {
                        continue;
                    }
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = cost + 1;
                        queue.add(new int[]{nr, nc, cost + 1});
                    } else {
                        if (map[nr][nc] <= cost + 1) {
                            continue;
                        }
                        map[nr][nc] = cost + 1;
                        queue.add(new int[]{nr, nc, cost + 1});
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, map[i][j]);
            }
        }
        System.out.println(ans);
        br.close();
    }
}
