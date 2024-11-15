import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
            cnt[a]++;
            cnt[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (findSet(i) != 1) {
                System.out.println("NO");
                return;
            }
        }
        int tmp = 0;
        for (int i = 1; i < n + 1; i++) {
            if ((cnt[i] & 1) != 0) {
                tmp++;
            }
            if (tmp > 2) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(tmp == 1 ? "NO" : "YES");
        br.close();
    }

    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }

    static void union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        if (parentA == parentB) {
            return;
        }
        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }
}
