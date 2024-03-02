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
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] delta = {u, -d};

        int[] visited = new int[f + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{s, 0});
        visited[s] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 2; i++) {
                int next = now[0] + delta[i];
                if (next < 1 || next > f || now[1] + 1 >= visited[next]) {
                    continue;
                }
                queue.add(new int[]{next, now[1] + 1});
                visited[next] = now[1] + 1;
            }
        }
        if (visited[g] == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(visited[g]);
        }
        br.close();
    }
}
