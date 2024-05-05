import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, startR, startC, endR, endC;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (map[i][j] == 'H') {
                    endR = i;
                    endC = j;
                } else if (map[i][j] == 'F') {
                    list.add(new int[]{i, j});
                }
            }
        }
        int INF = 1 << 29;
        int[][] forward = new int[N][M];
        int[][] reverse = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                forward[i][j] = reverse[i][j] = INF;
            }
        }
        bfs(forward, new boolean[N][M], startR, startC);
        bfs(reverse, new boolean[N][M], endR, endC);
        int ans = list.stream().mapToInt(a -> forward[a[0]][a[1]] + reverse[a[0]][a[1]]).min().orElse(-1);
        if (ans > INF) {
            ans = -1;
        }
        System.out.println(ans);
        br.close();
    }

    static void bfs(int[][] accMap, boolean[][] visited, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || visited[nr][nc] || map[nr][nc] == 'D') {
                    continue;
                }
                queue.add(new int[]{nr, nc, now[2] + 1});
                visited[nr][nc] = true;
                accMap[nr][nc] = now[2] + 1;
            }
        }
    }
}
