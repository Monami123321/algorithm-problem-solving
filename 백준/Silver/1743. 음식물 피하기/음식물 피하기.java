import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c]++;
        }
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    int tmp = 1;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int l = 0; l < 4; l++) {
                            int nr = now[0] + dr[l];
                            int nc = now[1] + dc[l];
                            if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || visited[nr][nc] || map[nr][nc] == 0) {
                                continue;
                            }
                            queue.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                            tmp++;
                        }
                    }
                    ans = Math.max(ans, tmp);
                }
            }
        }
        System.out.println(ans);

        br.close();
    }
}
