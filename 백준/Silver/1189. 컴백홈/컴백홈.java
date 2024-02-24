import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        ans = 0;
        dfs(R - 1, 0, 1, new boolean[R][C], map);
        System.out.println(ans);

        br.close();
    }

    static void dfs(int r, int c, int depth, boolean[][] visited, char[][] map) {

        if (r == 0 && c == C - 1) {
            if (depth == K) {
                ans++;
            }
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1 || visited[nr][nc] || map[nr][nc] == 'T') {
                continue;
            }
            dfs(nr, nc, depth + 1, visited, map);
        }
        visited[r][c] = false;

    }
}
