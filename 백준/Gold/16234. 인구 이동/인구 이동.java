import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, R, L;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (true) {
            boolean flag = false;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    boolean bfsFlag = false;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1 || visited[nr][nc] || Math.abs(map[i][j] - map[nr][nc]) < L || Math.abs(map[i][j] - map[nr][nc]) > R) {
                            continue;
                        }
                        bfsFlag = true;
                        break;
                    }
                    if (bfsFlag) {
                        visited[i][j] = true;
                        bfs(i, j, visited);
                        flag = true;

                    }

                }
            }
            if (!flag) {
                break;
            }
            cnt++;

        }
        System.out.println(cnt);
        br.close();
    }

    static void bfs(int startR, int startC, boolean[][] visited) {
        Queue<int[]> queue1 = new LinkedList<>();
        Queue<int[]> queue2 = new LinkedList<>();
        queue1.add(new int[]{startR, startC});
        int cnt = 0;
        int sum = 0;

        while (!queue1.isEmpty()) {
            int[] now = queue1.poll();
            int r = now[0];
            int c = now[1];
            sum += map[r][c];
            cnt++;
            queue2.add(now);
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1 || visited[nr][nc] || Math.abs(map[r][c] - map[nr][nc]) < L || Math.abs(map[r][c] - map[nr][nc]) > R) {
                    continue;
                }
                queue1.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        int num = sum / cnt;
        while (!queue2.isEmpty()) {
            int[] now = queue2.poll();
            map[now[0]][now[1]] = num;
        }
    }
}
