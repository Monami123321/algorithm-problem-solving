import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[503][503];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startC = Integer.parseInt(st.nextToken()) + 1;
            int startR = Integer.parseInt(st.nextToken()) + 1;
            int endC = Integer.parseInt(st.nextToken()) + 1;
            int endR = Integer.parseInt(st.nextToken()) + 1;
            if (startR > endR) {
                startR ^= endR;
                endR ^= startR;
                startR ^= endR;
            }
            if (startC > endC) {
                startC ^= endC;
                endC ^= startC;
                startC ^= endC;
            }
            map[startR][startC] += 1;
            map[startR][endC + 1] -= 1;
            map[endR + 1][startC] -= 1;
            map[endR + 1][endC + 1] += 1;
        }
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startC = Integer.parseInt(st.nextToken()) + 1;
            int startR = Integer.parseInt(st.nextToken()) + 1;
            int endC = Integer.parseInt(st.nextToken()) + 1;
            int endR = Integer.parseInt(st.nextToken()) + 1;
            if (startR > endR) {
                startR ^= endR;
                endR ^= startR;
                startR ^= endR;
            }
            if (startC > endC) {
                startC ^= endC;
                endC ^= startC;
                startC ^= endC;
            }
            map[startR][startC] += 1000;
            map[startR][endC + 1] -= 1000;
            map[endR + 1][startC] -= 1000;
            map[endR + 1][endC + 1] += 1000;
        }

        for (int i = 1; i <= 501; i++) {
            for (int j = 1; j <= 501; j++) {
                map[i][j] += map[i][j - 1];
            }
        }

        for (int i = 1; i <= 501; i++) {
            for (int j = 1; j <= 501; j++) {
                map[j][i] += map[j - 1][i];
            }
        }
        for (int i = 0; i < 503; i++) {
            map[0][i] = map[i][0] = map[502][i] = map[i][502] = 1000;

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{1, 1, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int r = now[0];
            int c = now[1];
            int w = now[2];
            if (r == 501 && c == 501) {
                System.out.println(w);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (map[nr][nc] >= 1000) {
                    continue;
                }
                if (map[nr][nc] >= 1) {
                    pq.add(new int[]{nr, nc, w + 1});
                    map[nr][nc] = 1000;
                } else {
                    pq.add(new int[]{nr, nc, w});
                    map[nr][nc] = 1000;
                }
            }
        }
        System.out.println(-1);
        br.close();
    }
}
