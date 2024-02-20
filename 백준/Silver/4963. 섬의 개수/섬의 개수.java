import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<int[]> queue = new LinkedList<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            if (w == 0) {
                break;
            }
            int h = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] != 0) {
                        cnt++;
                        bfs(map, queue, i, j, w, h);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static void bfs(int[][] map, Queue<int[]> queue, int startR, int startC, int w, int h) {
        queue.add(new int[]{startR, startC});
        map[startR][startC] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1 || map[nr][nc] == 0) {
                    continue;
                }

                queue.add(new int[]{nr, nc});
                map[nr][nc] = 0;
            }
        }
    }
}
