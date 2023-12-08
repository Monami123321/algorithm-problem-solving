import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;

    static int n, m, ansW, ansB;

    static Queue<int[]> queue;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean[][] visited;

    static void bfs(int r, int c) {
        char target = map[r][c];
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();


            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || visited[nr][nc] || map[nr][nc] != target) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
                cnt++;
            }

        }

        if (target == 'W') {
            ansW += cnt * cnt;
        } else {
            ansB += cnt * cnt;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j])
                    continue;
                bfs(i, j);
            }
        }

        System.out.print(ansW + " ");
        System.out.print(ansB);


    }
}
