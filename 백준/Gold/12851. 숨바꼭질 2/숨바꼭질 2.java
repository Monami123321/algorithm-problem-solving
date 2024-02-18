import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k <= n) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }
        int[] visited = new int[k * 2 + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        int cnt = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int cost = now[1];
            if (r == k) {
                if (ans > cost) {
                    ans = cost;
                    cnt = 1;
                } else if (ans == cost) {
                    cnt++;
                }
                continue;
            }

            int[] dr = {1, -1, r};
            for (int i = 0; i < 3; i++) {
                int nr = r + dr[i];
                if (nr < 0 || nr > k * 2 || visited[nr] < cost + 1) {
                    continue;
                }
                queue.add(new int[]{nr, cost + 1});
                visited[nr] = cost + 1;
            }

        }
        System.out.println(ans);
        System.out.println(cnt);


        br.close();
    }
}
