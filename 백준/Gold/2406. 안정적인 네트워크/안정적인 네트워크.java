import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        int pick = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (union(a, b)) {
                pick++;
            }
        }
        if (n == 0 || pick == n - 2) {
            System.out.print("0 0");
            return;
        }
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new int[]{i + 1, j + 1, arr[i][j]});
            }
        }
        int cost = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (pick < n - 2) {
            int[] now = pq.poll();
            if (union(now[0], now[1])) {
                pick++;
                cnt++;
                cost += now[2];
                sb.append(now[0]).append(" ").append(now[1]).append("\n");
            }
        }
        System.out.printf("%d %d\n", cost, cnt);
        System.out.print(sb);
        br.close();
    }

    static boolean union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        if (parentA == parentB) {
            return false;
        }
        if (parentA > parentB) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
        return true;
    }

    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }
}

