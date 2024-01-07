import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, cost});
            adjList[b].add(new int[]{a, cost});
        }
        int[] minEdge = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            minEdge[i] = Integer.MAX_VALUE;
        }
        minEdge[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[] visited = new boolean[n + 1];
        int[] prev = new int[n + 1];
        pq.add(new int[]{0, start, 0});

        while (true) {
            int[] now = pq.poll();
            int prevNode = now[0];
            int node = now[1];
            int cost = now[2];

            if (node == end) {
                minEdge[end] = cost;
                prev[node] = prevNode;
                break;
            }
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            minEdge[node] = cost;
            prev[node] = prevNode;

            adjList[node].forEach(e -> {
                if (visited[e[0]]) {
                    return;
                }
                pq.add(new int[]{node, e[0], cost + e[1]});
            });
        }
        int ans = minEdge[end];
        int tmp = end;
        int diff = 0;

        while (tmp != start) {
            diff = Math.max(diff, minEdge[tmp] - minEdge[prev[tmp]]);
            tmp = prev[tmp];
        }
        System.out.println(ans - diff);

        br.close();
    }
}
