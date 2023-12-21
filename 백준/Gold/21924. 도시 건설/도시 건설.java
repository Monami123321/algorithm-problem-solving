import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    static int findSet(int x) {
        if (parent[x] != x) {
            return parent[x] = parent[findSet(parent[x])];
        }
        return x;

    }

    static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        long total = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            total += cost;
            pq.add(new int[]{start, end, cost});
        }

        int pick = 0;
        long sum = 0;
        while (!pq.isEmpty() && pick < n - 1) {
            int[] now = pq.poll();
            if (findSet(now[0]) == findSet(now[1])) {
                continue;
            }
            if (now[0] > now[1]) {
                union(now[1], now[0]);
            } else {
                union(now[0], now[1]);
            }
            sum += now[2];
            pick++;
        }
        if (pick < n - 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(total - sum);


    }
}
