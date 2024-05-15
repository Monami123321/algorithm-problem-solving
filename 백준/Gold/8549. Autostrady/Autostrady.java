import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = c;
        }
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        int index = 0;
        int pick = 0;
        while (pick < n - 1) {
            if (union(edges[index][0], edges[index][1])) {
                pick++;
                index++;
            } else {
                index++;
            }
        }
        System.out.println(edges[index-1][2]);
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
