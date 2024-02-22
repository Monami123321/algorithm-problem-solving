import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int total = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    total++;
                }
            }
        }
        int t = 0;
        while (total > 0) {
            total -= del(map, new int[N][M]);
            t++;
        }
        System.out.println(t);
        br.close();
    }

    static int del(int[][] map, int[][] caseMap) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        caseMap[0][0] = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1 || caseMap[nr][nc] < 0) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    caseMap[nr][nc]++;
                    continue;
                }
                queue.add(new int[]{nr, nc});
                caseMap[nr][nc] = -1;
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (caseMap[i][j] > 1) {
                    map[i][j] = 0;
                    res++;
                }
            }
        }
        return res;
    }
}
