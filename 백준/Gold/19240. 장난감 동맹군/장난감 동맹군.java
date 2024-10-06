import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        outer:
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[n + 1];
            visited = new int[n + 1];
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
                    if (!bfs(i)) {
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

    static boolean bfs(int node) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node, 0});
        visited[node] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int no = now[0];
            int mark = now[1];

            for (int c : adjList[no]) {
                if (visited[c] == -1) {
                    queue.add(new int[]{c, mark ^ 1});
                    visited[c] = mark ^ 1;
                } else {
                    if (visited[c] == mark) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
