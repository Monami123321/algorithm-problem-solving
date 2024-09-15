import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int from, to;
        double dist;

        public Edge(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
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
        Edge[] edges = new Edge[n * (n - 1) >> 1];
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double x = arr[i][0] - arr[j][0];
                double y = arr[i][1] - arr[j][1];
                edges[index++] = new Edge(i, j, Math.sqrt(x * x + y * y));
            }
        }
        Arrays.sort(edges, Comparator.comparingDouble(a -> a.dist));
        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        double cost = 0;
        index = 0;
        int cnt = 0;
        while (cnt < n - 1) {
            if (union(edges[index].from, edges[index].to)) {
                cost += edges[index].dist;
                cnt++;
            }
            index++;
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
