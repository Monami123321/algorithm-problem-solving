import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[5][5];
    static boolean flag = false;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        dfs(0, r, c, 0);
        System.out.println(flag ? 1 : 0);


        br.close();
    }

    static void dfs(int depth, int r, int c, int a) {
        if (flag) {
            return;
        }

        if (a == 2) {
            flag = true;
            return;
        }

        if (depth == 3) {
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr > 4 || nc < 0 || nc > 4 || visited[nr][nc] || map[nr][nc] == -1) {
                continue;
            }
            if (map[nr][nc] == 0) {
                dfs(depth + 1, nr, nc, a);
            } else {
                dfs(depth + 1, nr, nc, a + 1);
            }
        }
        visited[r][c] = false;
    }
}
