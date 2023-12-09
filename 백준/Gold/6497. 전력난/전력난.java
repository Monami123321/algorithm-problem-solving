import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int n, m;

    static int[] parent;

    static int findSet(int x) {
        if (parent[x] != x) {
            return parent[x] = findSet(parent[x]);
        }
        return x;
    }

    static void union(int x, int y) {
        if (x > y) {
            parent[findSet(x)] = findSet(y);
        } else {
            parent[findSet(y)] = findSet(x);
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            if (m == 0) {
                break;
            }
            n = Integer.parseInt(st.nextToken());


            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }

            int totalCost = 0;
            int[][] edges = new int[n][3];


            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges[i][0] = x;
                edges[i][1] = y;
                edges[i][2] = z;
                totalCost += z;

            }

            Arrays.sort(edges, (a, b) -> a[2] - b[2]);

            int pick = 0;
            int idx = 0;
            int pickedCost = 0;
            while (pick < m - 1) {
                if (findSet(edges[idx][0]) == findSet(edges[idx][1])) {
                    idx++;
                    continue;
                }
                union(edges[idx][0], edges[idx][1]);
                pickedCost += edges[idx][2];
                pick++;
                idx++;
            }

            sb.append(totalCost - pickedCost).append("\n");

        }

        System.out.print(sb);
        br.close();

    }
}
