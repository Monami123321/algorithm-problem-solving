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
        int k = Integer.parseInt(st.nextToken());
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == k - 1) {
                continue;
            }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        long cnt = bfs(adjList, queue, 1, new boolean[n + 1]);
        System.out.println(cnt * (n - cnt));
        br.close();
    }

    static int bfs(List<Integer>[] adjList, Queue<Integer> queue, int start, boolean[] visited) {
        queue.add(start);
        visited[start] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int n : adjList[node]) {
                if (!visited[n]) {
                    cnt++;
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
        return cnt;
    }
}
