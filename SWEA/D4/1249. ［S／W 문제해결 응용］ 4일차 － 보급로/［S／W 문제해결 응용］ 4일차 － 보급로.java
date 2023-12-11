import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());

        tc:
        for (int i = 1; i <= testCases; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n][n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), "0123456789", true);
                for (int k = 0; k < n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            boolean[][] visited = new boolean[n][n];

            pq.add(new int[]{0, 0, map[0][0]});

            while (!pq.isEmpty()) {
                int[] now = pq.poll();
                int r = now[0];
                int c = now[1];
                int accCost = now[2];
                if (r == n - 1 && c == n - 1) {
                    sb.append("#").append(i).append(" ").append(accCost).append("\n");
                    continue tc;
                }
                if(visited[r][c])
                    continue ;
                visited[r][c] = true;

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1 || visited[nr][nc]) {
                        continue;
                    }

                    pq.add(new int[]{nr, nc, accCost + map[nr][nc]});


                }

            }


        }
        System.out.print(sb);

    }

}
