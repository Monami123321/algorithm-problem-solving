import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                visited[i][j] = -1;
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        q.add(new int[]{0, 0, 0});
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            List<int[]> list = new ArrayList<>();
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int r = now[0];
                int c = now[1];
                int val = now[2];

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) {
                        continue;
                    }
                    if (visited[nr][nc] >= 0) {
                        continue;
                    }
                    if (map[nr][nc] == '0') {
                        list.add(new int[]{nr, nc, val + 1});
                        visited[nr][nc] = val + 1;
                    } else {
                        q.add(new int[]{nr, nc, val});
                        visited[nr][nc] = val;
                    }
                }
            }
            q.addAll(list);
        }
        System.out.println(visited[n - 1][n - 1]);
        br.close();
    }
}
