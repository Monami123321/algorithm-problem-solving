import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        int start = Integer.MAX_VALUE;
        int end = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            start = Math.min(start, c);
            end = Math.max(end, c);
            adjList[a].add(new int[]{b, c});
            adjList[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        while (start <= end) {
            int mid = start + end >> 1;
            if (bfs(n, s, e, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
        br.close();
    }

    static boolean bfs(int n, int st, int ed, int limit) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.add(st);
        visited[st] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == ed) {
                return true;
            }
            adjList[now].forEach(e -> {
                if (visited[e[0]] || e[1] < limit) {
                    return;
                }
                q.add(e[0]);
                visited[e[0]] = true;
            });
        }
        return false;
    }
}
