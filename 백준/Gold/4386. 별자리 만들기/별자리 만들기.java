import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {

        int from, to;
        double dist;

        public Edge(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge edge) {
            return Double.compare(this.dist, edge.dist);
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double x = arr[i][0] - arr[j][0];
                double y = arr[i][1] - arr[j][1];
                pq.add(new Edge(i, j, Math.sqrt(x * x + y * y)));
            }
        }
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        double cost = 0;
        int cnt = 0;
        while (cnt < n - 1) {
            Edge edge = pq.poll();
            if (union(edge.from, edge.to)) {
                cost += edge.dist;
                cnt++;
            }
        }
        System.out.println(cost);


        br.close();

    }

    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }

    static boolean union(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a == b) {
            return false;
        }
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
        return true;
    }


}
