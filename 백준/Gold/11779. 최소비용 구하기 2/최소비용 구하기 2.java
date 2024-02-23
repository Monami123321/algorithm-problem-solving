import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[]{b, c});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n + 1];
        int[] prev = new int[n + 1];
        int cost = 0;
        pq.add(new int[]{start, 0, -1});
        while (true) {
            int[] now = pq.poll();
            if (visited[now[0]]) {
                continue;
            }
            prev[now[0]] = now[2];
            if (now[0] == end) {
                cost =now[1];
                break;
            }
            visited[now[0]] = true;

            adjList[now[0]].forEach(e -> {
                if (visited[e[0]]) {
                    return;
                }
                pq.add(new int[]{e[0], e[1] + now[1], now[0]});
            });
        }

        Stack<Integer> stack = new Stack<>();

        while (end != -1) {
            stack.push(end);
            end = prev[end];
        }
        sb.append(cost).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
