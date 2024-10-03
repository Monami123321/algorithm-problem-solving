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
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
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
            adjList[b].add(new int[]{a, c});
        }
        int ans = -1;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{start, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int c = now[1];
            int mc = now[2];
            if (visited[node] || c > cost) {
                continue;
            }
            if (node == end) {
                ans = mc;
                break;
            }
            visited[node] = true;
            adjList[node].forEach(e -> {
                if (visited[e[0]]) {
                    return;
                }
                pq.add(new int[]{e[0], e[1] + c, Math.max(mc, e[1])});
            });
        }
        System.out.println(ans);
        br.close();
    }
}
