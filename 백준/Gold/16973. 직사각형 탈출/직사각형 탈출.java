import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int startR = Integer.parseInt(st.nextToken()) - 1;
        int startC = Integer.parseInt(st.nextToken()) - 1;
        int endR = Integer.parseInt(st.nextToken()) - 1;
        int endC = Integer.parseInt(st.nextToken()) - 1;

//        list.forEach(e -> {
//            int r = Math.max(e[0] - (h - 1), 0);
//            int c = Math.max(e[1] - (w - 1), 0);
//            map[r][c]++;
//            if (e[0] < n - 1) {
//                map[e[0] + 1][c]--;
//            }
//            if (e[1] < m - 1) {
//                map[r][e[1] + 1]--;
//            }
//            if (e[0] < n - 1 && e[1] < m - 1) {
//                map[e[0] + 1][e[1] + 1]++;
//            }
//            map[e[0]][e[1]]--;
//        });
        for (int[] arr : list) {
            int r = Math.max(arr[0] - (h - 1), 0);
            int c = Math.max(arr[1] - (w - 1), 0);
            map[r][c]++;
            if (arr[0] < n - 1) {
                map[arr[0] + 1][c]--;
            }
            if (arr[1] < m - 1) {
                map[r][arr[1] + 1]--;
            }
            if (arr[0] < n - 1 && arr[1] < m - 1) {
                map[arr[0] + 1][arr[1] + 1]++;
            }
            map[arr[0]][arr[1]]--;
        }
        if (h > 1) {
            map[n - (h - 1)][0]++;
        }
        if (w > 1) {
            map[0][m - (w - 1)]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] += map[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[j][i] += map[j - 1][i];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0});
        int ans = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int cost = now[2];
            if (r == endR && c == endC) {
                ans = cost;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > n - 1 || nc < 0 || nc > m - 1 || map[nr][nc] != 0) {
                    continue;
                }
                queue.add(new int[]{nr, nc, cost + 1});
                map[nr][nc] = 1;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
