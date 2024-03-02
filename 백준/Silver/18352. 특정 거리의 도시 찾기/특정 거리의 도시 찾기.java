import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
        }


        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});
        List<Integer> list = new ArrayList<>();
        int pick = 0;
        while (!pq.isEmpty() && pick < n) {
            int[] now = pq.poll();
            if (visited[now[0]]) {
                continue;
            }
            if (now[1] > k) {
                break;
            }
            visited[now[0]] = true;
            pick++;
            if (now[1] == k) {
                list.add(now[0]);
            }

            adjList[now[0]].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                pq.add(new int[]{e, now[1] + 1});
            });
        }
        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        list.stream().sorted().forEach(e -> {
            sb.append(e).append("\n");
        });
        System.out.print(sb);
        br.close();
    }
}
