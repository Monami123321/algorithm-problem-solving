import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        cnt = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            cnt[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (i == k - 1) {
                continue;
            }
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        long l = cnt[findSet(1)];
        System.out.println(l * (n - l));
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

