import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[][] arr = new char[2][n]; // 0 못감 1 가능
        for (int i = 0; i < 2; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0}); // {행 열 t}
        boolean[][] visited = new boolean[2][n];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int t = now[2];

            if (c + k >= n) {
                System.out.println(1);
                return;
            }

            // 앞
            if (!visited[r][c + 1] && arr[r][c + 1] == 49) {
                queue.add(new int[]{r, c + 1, t + 1});
                visited[r][c + 1] = true;
            }

            // 뒤

            if (c > 0 && !visited[r][c - 1] && arr[r][c - 1] == 49 && c - 1 >= t + 1) {
                queue.add(new int[]{r, c - 1, t + 1});
                visited[r][c - 1] = true;
            }

            // 점프

            if (!visited[r ^ 1][c + k] && arr[r ^ 1][c + k] == 49) {
                queue.add(new int[]{r ^ 1, c + k, t + 1});
                visited[r ^ 1][c + k] = true;
            }
        }
        System.out.println(0);
        br.close();
    }
}
