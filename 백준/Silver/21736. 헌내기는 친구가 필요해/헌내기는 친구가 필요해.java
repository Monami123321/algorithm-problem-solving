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
        char[][] map = new char[n][];
        int startR = 0;
        int startC = 0;
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    startR = i;
                    startC = j;
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            if (map[r][c] == 'P') {
                ++ans;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || visited[nr][nc] || map[nr][nc] == 'X') {
                    continue;
                }
                queue.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        if (ans == 0) {
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
        br.close();
    }
}
