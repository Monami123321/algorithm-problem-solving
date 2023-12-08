import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<int[]> queue = new LinkedList<>();
        int tc = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            tc++;
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            int[][] accMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    accMap[i][j] = Integer.MAX_VALUE;

                }
            }
            accMap[0][0] = map[0][0];
            queue.add(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];

                    if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || accMap[nr][nc] <= accMap[now[0]][now[1]] + map[nr][nc]) {
                        continue;
                    }

                    queue.add(new int[]{nr, nc});
                    accMap[nr][nc] = accMap[now[0]][now[1]] + map[nr][nc];

                }

            }
            sb.append("Problem ").append(tc).append(": ").append(accMap[n - 1][n - 1]).append("\n");


        }
        System.out.print(sb);
    }
}
