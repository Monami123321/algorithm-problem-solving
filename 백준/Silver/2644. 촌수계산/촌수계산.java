import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
            union(a, b);
        }
        if (findSet(y) != findSet(x)) {
            System.out.println(-1);
        } else {
            Queue<int[]> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];
            queue.add(new int[]{x, 0});
            visited[x] = true;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[0] == y) {
                    System.out.println(now[1]);
                    return;
                }
                adjList[now[0]].forEach(e -> {
                    if (visited[e]) {
                        return;
                    }
                    visited[e] = true;
                    queue.add(new int[]{e, now[1] + 1});
                });
            }
        }
        br.close();
    }

    static void union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        if (parentA == parentB) {
            return;
        }
        if (parentA > parentB) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
    }

    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }
}
