import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n+1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, c});
            adjList[b].add(new int[]{a, c});
        }
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (visited[now[0]]) {
                continue;
            }
            if (now[0] == n) {
                System.out.println(now[1]);
                return;
            }
            visited[now[0]] = true;
            adjList[now[0]].forEach(e -> {
                if (visited[e[0]]) {
                    return;
                }
                pq.add(new int[]{e[0], e[1] + now[1]});
            });
        }
        br.close();
    }
}
