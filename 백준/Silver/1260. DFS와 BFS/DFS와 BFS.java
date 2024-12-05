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
        int v = Integer.parseInt(st.nextToken());
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            adjList[i].sort(Collections.reverseOrder());
        }
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(v);
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int node = deque.pop();
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            sb.append(node).append(" ");
            adjList[node].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                deque.push(e);
            });
        }
        sb.append("\n");
        for (int i = 1; i <= n; i++) {
            Collections.reverse(adjList[i]);
        }
        Arrays.fill(visited, false);
        deque.add(v);
        visited[v] = true;
        while (!deque.isEmpty()) {
            int node = deque.poll();
            sb.append(node).append(" ");
            adjList[node].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                visited[e] = true;
                deque.add(e);
            });
        }
        System.out.print(sb);
        br.close();
    }
}
