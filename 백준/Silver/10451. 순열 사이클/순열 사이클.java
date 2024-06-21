import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            adjList = new ArrayList[n + 1];
            for (int i = 1; i < n + 1; i++) {
                adjList[i] = new ArrayList<>();
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
            boolean[] visited = new boolean[n + 1];
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (bfs(i, visited)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    static boolean bfs(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            stack.push(now);
            int next = adjList[now].get(0);
            if (visited[next]) {
                while (!stack.isEmpty()) {
                    if (stack.pop() == next) {
                        return true;
                    }
                }
                return false;
            }
            visited[next] = true;
            queue.add(next);
        }
        return false;
    }
}
