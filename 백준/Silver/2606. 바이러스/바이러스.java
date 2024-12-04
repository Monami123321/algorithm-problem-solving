import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            cnt[i] = 1;
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(cnt[1] - 1);
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
            cnt[parentA] += cnt[parentB];
        } else {
            parent[parentA] = parentB;
            cnt[parentB] += cnt[parentA];
        }
    }
}
