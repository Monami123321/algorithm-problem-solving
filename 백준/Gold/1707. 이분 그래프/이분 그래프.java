import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        outer:
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Integer>[] adjList = new ArrayList[n + 1];
            int[] visited = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                adjList[i] = new ArrayList<>();
                visited[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjList[a].add(b);
                adjList[b].add(a);
            }

            for (int i = 1; i < n + 1; i++) {
                if (visited[i] == -1) {
                    if (!bfs(adjList, i, visited)) {
                        sb.append("NO\n");
                        continue outer;
                    }
                }
            }
            sb.append("YES\n");
        }
        System.out.print(sb);
        br.close();
    }

    static boolean bfs(List<Integer>[] adjList, int node, int[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = 0;
        queue.add(node);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int c : adjList[now]) {
                if (visited[c] == -1) {
                    visited[c] = visited[now] ^ 1;
                    queue.add(c);
                } else {
                    if (visited[c] == visited[now]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
