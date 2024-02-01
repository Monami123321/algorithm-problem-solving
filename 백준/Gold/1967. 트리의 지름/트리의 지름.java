import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
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
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        visited[1] = true;
        queue.add(new int[]{1, 0});

        int endNode = 1;
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int node = now[0];
            int cost = now[1];

            if (cost > sum) {
                sum = cost;
                endNode = node;
            }

            adjList[node].forEach(e -> {
                if (visited[e[0]]) {
                    return;
                }
                visited[e[0]] = true;
                queue.add(new int[]{e[0], cost + e[1]});
            });
        }
        sum = 0;
        visited = new boolean[n + 1];
        queue.add(new int[]{endNode, 0});
        visited[endNode] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int node = now[0];
            int cost = now[1];

            if (cost > sum) {
                sum = cost;
            }

            adjList[node].forEach(e -> {
                if (visited[e[0]]) {
                    return;
                }
                visited[e[0]] = true;
                queue.add(new int[]{e[0], cost + e[1]});
            });


        }
        System.out.println(sum);


        br.close();
    }
}
