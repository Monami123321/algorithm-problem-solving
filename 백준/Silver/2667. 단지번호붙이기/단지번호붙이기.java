import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans = 0;
    static int n;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                list.add(bfs(i, j));
            }
        }
        sb.append(ans).append("\n");
        Collections.sort(list);
        list.forEach(e -> {
            sb.append(e).append("\n");
        });
        System.out.print(sb);


        br.close();
    }

    static int bfs(int r, int c) {
        ans++;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            res++;
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc] || map[nr][nc] == 0) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }

        }
        return res;
    }
}
