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
        int start = Integer.parseInt(br.readLine());
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, c});
        }
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            if (visited[node] != Integer.MAX_VALUE) {
                continue;
            }
            visited[node] = cost;
            adjList[node].forEach(e -> {
                if (visited[e[0]] == Integer.MAX_VALUE) {
                    pq.add(new int[]{e[0], cost + e[1]});
                }
            });
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(visited[i]).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
