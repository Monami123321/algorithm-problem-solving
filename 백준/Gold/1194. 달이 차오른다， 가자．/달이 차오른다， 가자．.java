import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        // a b c d e f
        // {r, c, mask, depth}
        int ans = -1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][(1 << 6)];
        bfs:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    queue.add(new int[]{i, j, 0, 0});
                    visited[i][j][0] = true;
                    break bfs;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int mask = now[2];
            int depth = now[3];

            if (map[r][c] == '1') {
                ans = depth;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || visited[nr][nc][mask] || map[nr][nc] == '#') {
                    continue;
                }
                // 대문자인 경우 -> 갈수있는지 확인
                if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
                    // 열쇠가 있어서 갈 수 있다
                    if ((mask & (1 << (map[nr][nc] - 'A'))) != 0) {
                        queue.add(new int[]{nr, nc, mask, depth + 1});
                        visited[nr][nc][mask] = true;
                        continue;
                    } else {
                        continue;
                    }
                }
                // 소문자 -> mask 업데이트
                if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
                    int nextMask = (mask | (1 << (map[nr][nc] - 'a')));

                    if (visited[nr][nc][nextMask]) {
                        continue;
                    }
                    queue.add(new int[]{nr, nc, nextMask, depth + 1});
                    visited[nr][nc][nextMask] = true;
                    continue;
                }
                queue.add(new int[]{nr, nc, mask, depth + 1});
                visited[nr][nc][mask] = true;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
