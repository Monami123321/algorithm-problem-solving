import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;


    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }

    static void union(int a, int b) {
        if (a == b) {
            return;
        } else if (a > b) {
            parent[findSet(a)] = findSet(b);

        } else {
            parent[findSet(b)] = findSet(a);
        }
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

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i][0] = a;
            edges[i][1] = b;
            edges[i][2] = c;
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int pick = 0;
        int cnt = 0;
        int index = 0;
        while (pick < n - 2) {
            int start = edges[index][0];
            int end = edges[index][1];
            int cost = edges[index][2];

            if (findSet(start) == findSet(end)) {
                index++;
            } else {
                union(start, end);
                index++;
                cnt += cost;
                pick++;
            }
        }
        System.out.println(cnt);


    }
}
