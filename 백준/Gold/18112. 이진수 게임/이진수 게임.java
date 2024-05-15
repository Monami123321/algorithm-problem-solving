import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine(), 2);
        int k = Integer.parseInt(br.readLine(), 2);
        int index = 0;
        int num = Math.max(n, k);
        while (1 << index <= num) {
            index++;
        }
        int[] visited = new int[1 << index];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            index = 0;
            while (1 << index <= now[0]) {
                index++;
            }
            index -= 2;
            for (int i = index; i >= 0; i--) {
                int next = now[0] ^ 1 << i;

                if (next > visited.length - 1 || visited[next] <= now[1] + 1) {
                    continue;
                }
                queue.add(new int[]{next, now[1] + 1});
                visited[next] = now[1] + 1;
            }

            int next = now[0] + 1;
            if (next < visited.length && visited[next] > now[1] + 1) {
                queue.add(new int[]{next, now[1] + 1});
                visited[next] = now[1] + 1;
            }
            next = now[0] - 1;
            if (next >= 0 && visited[next] > now[1] + 1) {
                queue.add(new int[]{next, now[1] + 1});
                visited[next] = now[1] + 1;
            }
        }
        System.out.println(visited[k]);
        br.close();
    }
}
