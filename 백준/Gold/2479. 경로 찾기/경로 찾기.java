import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine(), 2);
        }
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }


        // 해밍거리가 1이면 경로가 있다
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (Integer.bitCount(arr[i] ^ arr[j]) == 1) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[] visited = new boolean[n + 1];
        int[] route = new int[n + 1];
        pq.add(new int[]{0, start, 0}); // {prev, now}
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int prev = now[0];
            int curr = now[1];
            int cost = now[2];
            if (visited[curr]) {
                continue;
            }
            route[curr] = prev;
            visited[curr] = true;
            if (curr == end) {
                break;
            }

            adjList[curr].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                pq.add(new int[]{curr, e, cost + 1});
            });
        }
        if (route[end] == 0) {
            System.out.println(-1);
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int now = end;
        while (now != 0) {
            stack.push(now);
            now = route[now];
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
