import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent, cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        cnt = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            cnt[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                war(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int p = findSet(i);
            if (!visited[p]) {
                visited[p] = true;
                list.add(cnt[p]);
                ans++;
            }
        }
        list.stream().sorted().forEach(e -> sb.append(e).append(" "));
        System.out.println(ans);
        System.out.print(sb);
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
        if (parentA < parentB) {
            parent[parentB] = parentA;
            cnt[parentA] += cnt[parentB];
        } else {
            parent[parentA] = parentB;
            cnt[parentB] += cnt[parentA];
        }
    }

    static void war(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);

        if (cnt[parentA] == cnt[parentB]) {
            visited[parentA] = true;
            visited[parentB] = true;
        } else if (cnt[parentA] > cnt[parentB]) {
            cnt[parentA] -= cnt[parentB];
            parent[parentB] = parentA;
        } else {
            cnt[parentB] -= cnt[parentA];
            parent[parentA] = parentB;
        }
    }
}
