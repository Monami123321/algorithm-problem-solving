import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        boolean[] visited = new boolean[n + 1];
        int ans = 0;
        for (int i = 1; i < n+1; i++) {
            if (visited[findSet(i)]) {
                continue;
            }
            visited[findSet(i)] = true;
            ans++;
        }
        System.out.println(ans);
        br.close();
    }
}
