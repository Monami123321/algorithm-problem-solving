import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int ans, w, h;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static Queue<int[]> queue = new LinkedList<>();

    static int bfs(int startR, int startC) {
        boolean[][] visited = new boolean[h][w];
        queue.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;
        int res = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int time = now[2];
            res = time > res ? time : res;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || visited[nr][nc] || map[nr][nc] == 'W') {
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, time + 1});

            }
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;

        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'L') {
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }

        System.out.println(ans);


    }
}
