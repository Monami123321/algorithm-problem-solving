import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        } else if (y > x) {
            parent[findSet(y)] = findSet(x);
        } else {
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = 0;
        while (true) {
            tc++;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            parent = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i < n; i++) {
                parent[i] = i;
            }
            int m = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (findSet(a) == findSet(b)) {
                    list.add(findSet(a));
                    union(a, b);
                } else {
                    union(a, b);
                }
            }
            list.forEach(e -> {
                visited[findSet(e)] = true;
            });
            int treeNum = 0;
            boolean[] counted = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                int tmp = findSet(i);
                if (visited[tmp] || counted[tmp]) {
                    continue;
                }
                treeNum++;
                counted[tmp] = true;
            }
            if (treeNum == 0) {
                sb.append("Case ").append(tc).append(": No trees.\n");
            } else if (treeNum == 1) {
                sb.append("Case ").append(tc).append(": There is one tree.\n");
            } else {
                sb.append("Case ").append(tc).append(": A forest of ").append(treeNum).append(" trees.\n");
            }
        }
        System.out.print(sb);


        br.close();
    }

}
