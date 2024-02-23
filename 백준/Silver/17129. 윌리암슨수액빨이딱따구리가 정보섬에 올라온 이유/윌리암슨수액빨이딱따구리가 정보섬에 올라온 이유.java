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
        int[][] map = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - 48;
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                    map[i][j] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int cost = now[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] == 1) {
                    continue;
                }
                if (map[nr][nc] > 2) {
                    System.out.println("TAK");
                    System.out.println(cost+1);
                    return;
                }
                queue.add(new int[]{nr, nc, cost + 1});
                map[nr][nc] = 1;
            }
        }
        System.out.println("NIE");
        br.close();
    }
}
