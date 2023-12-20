import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;

    static void dfs(int r, int c, int depth, int score) {
        if (depth == T) {
            ans = Math.max(score, ans);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || map[nr][nc] == '#' || visited[nr][nc]) {
                continue;
            }

            if (map[nr][nc] == 'S') {
                visited[nr][nc] = true;
                dfs(nr, nc, depth + 1, score + 1);
                visited[nr][nc] = false;
            } else {
                dfs(nr, nc, depth + 1, score);
            }

        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        ans = 0;
        int[] startPoint = new int[2];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'G') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                }

            }
        }
        dfs(startPoint[0],startPoint[1],0,0);
        System.out.println(ans);
        br.close();
    }
}
