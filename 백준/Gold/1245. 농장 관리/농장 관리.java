import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M, ans;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;

    static boolean check(int r, int c) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (r + i < 0 || r + i > N - 1 || c + j < 0 || c + j > M - 1) {
                    continue;
                }
                if (map[r + i][c + j] > map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void bfs(int startR, int startC) {

        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        boolean flag = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            if (flag) {
                flag = check(r, c);
            }

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || visited[nr][nc] || map[nr][nc] != map[startR][startC]) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        if (flag) {
            ans++;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(i, j);
            }
        }
        System.out.println(ans);
        br.close();
    }
}
