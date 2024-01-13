import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static boolean[] check;
    static int h, w, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = tmp.charAt(j) - 65;
            }
        }
        check = new boolean[26];
        visited = new boolean[h][w];
        dfs(0, 0, 1);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int r, int c, int depth) {
        visited[r][c] = true;
        check[map[r][c]] = true;
        ans = ans < depth ? depth : ans;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || visited[nr][nc] || check[map[nr][nc]]) {
                continue;
            }
            dfs(nr, nc, depth + 1);
        }
        visited[r][c] = false;
        check[map[r][c]] = false;
    }
}
