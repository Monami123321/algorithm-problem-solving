import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;


        st = new StringTokenizer(br.readLine());
        int endR = Integer.parseInt(st.nextToken()) - 1;
        int endC = Integer.parseInt(st.nextToken()) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{startR, startC, 0});
        visited[startR][startC] = true;
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int t = now[2];
            if (r == endR && c == endC) {
                ans = t;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isPossiblePos(nr, nc, a, b, map) && !visited[nr][nc]) {
                    queue.add(new int[]{nr, nc, t + 1});
                    visited[nr][nc] = true;
                }
            }
        }
        System.out.println(ans);

        br.close();
    }

    static boolean isPossiblePos(int r, int c, int a, int b, int[][] map) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int nr = r + i;
                int nc = c + j;
                if (nr < 0 || nr > map.length - 1 || nc < 0 || nc > map[0].length - 1 || map[nr][nc] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
