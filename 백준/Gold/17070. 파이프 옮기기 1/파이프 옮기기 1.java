import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, ans;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        dfs(0, 1, 0);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int r, int c, int pos) {
        if (r == N - 1 && c == N - 1) {
            ans++;
            return;
        }

        if (pos == 0) {
            for (int i = 0; i < 2; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr > N - 1 || nc > N - 1 || map[nr][nc] == 1) {
                    continue;
                }
                if (i == 1) {
                    if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) {
                        continue;
                    }
                }
                dfs(nr, nc, i);

            }

        } else if (pos == 1) {
            for (int i = 0; i < 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr > N - 1 || nc > N - 1 || map[nr][nc] == 1) {
                    continue;
                }
                if (i == 1) {
                    if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) {
                        continue;
                    }
                }
                dfs(nr, nc, i);

            }

        } else {
            for (int i = 1; i < 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr > N - 1 || nc > N - 1 || map[nr][nc] == 1) {
                    continue;
                }
                if (i == 1) {
                    if (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1) {
                        continue;
                    }
                }
                dfs(nr, nc, i);

            }

        }

    }
}


