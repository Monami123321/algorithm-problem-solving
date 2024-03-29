import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dr = {-2, -2, 2, 2, 1, -1, 1, -1};
    static int[] dc = {-1, 1, -1, 1, -2, -2, 2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String ed = br.readLine();
        int startC = st.charAt(0) - 'a';
        int startR = 8 - (st.charAt(1) - '0');
        int endC = ed.charAt(0) - 'a';
        int endR = 8 - (ed.charAt(1) - '0');

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0});
        boolean[][] visited = new boolean[8][8];
        visited[startR][startC] = true;
        int ans = 0;
        while (true) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int cost = now[2];
            if (r == endR && c == endC) {
                ans = cost;
                break;
            }
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr > 7 || nc < 0 || nc > 7 || visited[nr][nc]) {
                    continue;
                }
                queue.add(new int[]{nr, nc, cost + 1});
                visited[nr][nc] = true;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
