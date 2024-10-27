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
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] ans = new int[n + 1];
        int cnt = 1;
        queue.add(start);
        visited[start] = true;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ans[now] = cnt++;
            adjList[now].stream().sorted(Comparator.reverseOrder()).forEach(e -> {
                if (visited[e]) {
                    return;
                }
                visited[e] = true;
                queue.add(e);
            });
        }
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
