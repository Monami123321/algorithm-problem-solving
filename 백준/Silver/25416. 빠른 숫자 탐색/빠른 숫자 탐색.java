import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        int ans = -1;
        q.add(new int[]{startR, startC, 0});
        map[startR][startC] = -1;
        outer:
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];
            int t = now[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > 4 || nc < 0 || nc > 4 || map[nr][nc] == -1) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    ans = t + 1;
                    break outer;
                }

                q.add(new int[]{nr, nc, t + 1});
                map[nr][nc] = -1;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
