import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[start].add(new int[]{end, cost});
            adjList[end].add(new int[]{start, cost});
        }
        res = new int[3][n + 1];
        dijkstra(a, adjList, 0);
        dijkstra(b, adjList, 1);
        dijkstra(c, adjList, 2);
        int max = 0;
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                tmp = Math.min(tmp, res[j][i]);
            }
            if (tmp > max) {
                ans = i;
                max = tmp;
            }
        }
        System.out.println(ans);
        br.close();

    }

    static void dijkstra(int node, List<int[]>[] adjList, int index) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{node, 0});
        boolean[] visited = new boolean[adjList.length];
        int pick = adjList.length - 1;
        while (pick > 0) {
            int[] now = pq.poll();
            int n = now[0];
            int cost = now[1];
            if (visited[n]) {
                continue;
            }
            visited[n] = true;
            res[index][n] = cost;
            pick--;

            adjList[n].forEach(e -> {
                if (visited[e[0]]) {
                    return;
                }
                pq.add(new int[]{e[0], e[1] + cost});
            });
        }
    }
}
