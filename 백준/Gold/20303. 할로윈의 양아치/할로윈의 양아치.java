import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, cnt, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        parent = new int[n + 1];
        cnt = new int[n + 1];
        size = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            size[i] = 1;
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int[] arr = new int[k];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int target = findSet(i);
            if (visited[target]) {
                continue;
            }
            visited[target] = true;
            int w = size[target];
            int v = cnt[target];
            for (int j = k - 1; j >= w; j--) {
                arr[j] = Math.max(arr[j - w] + v, arr[j]);
            }
        }
        System.out.println(arr[k - 1]);
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

        if (parentB == parentA) {
            return;
        }

        if (parentA < parentB) {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
            cnt[parentA] += cnt[parentB];
        } else {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
            cnt[parentB] += cnt[parentA];
        }
    }
}
