import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<int[]>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
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
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[] prev = new int[n + 1];
        int c = 0;
        pq.add(new int[]{start, start, 0});


        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int curr = now[0];
            int pre = now[1];
            int cost = now[2];
            if (prev[curr] != 0) {
                continue;
            }
            prev[curr] = pre;
            if (curr == end) {
                c = cost;
                break;
            }
            adjList[curr].forEach(e -> {
                if (prev[e[0]] != 0) {
                    return;
                }
                pq.add(new int[]{e[0], curr, cost + e[1]});
            });
        }
        Stack<Integer> stack = new Stack<>();
        while (end != start) {
            stack.push(end);
            end = prev[end];
        }
        stack.push(start);
        StringBuilder sb = new StringBuilder();
        sb.append(c).append("\n");
        sb.append(stack.size()).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
