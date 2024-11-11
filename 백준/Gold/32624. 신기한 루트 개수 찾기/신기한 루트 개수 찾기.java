import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int root = Integer.parseInt(st.nextToken());
        int leaf = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        dfs(root, 0);
        visited = new boolean[n + 1];
        visited[root] = visited[leaf] = true;
        leaf = parent[leaf];
        System.out.println(leaf == root ? 0 : bfs(leaf));
        br.close();
    }

    static void dfs(int node, int prev) {
        parent[node] = prev;
        visited[node] = true;
        adjList[node].forEach(e -> {
            if (visited[e]) {
                return;
            }
            dfs(e, node);
        });
    }

    static int bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            cnt++;
            adjList[now].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                queue.add(e);
                visited[e] = true;
            });
        }
        return cnt;
    }
}