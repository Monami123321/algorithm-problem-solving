import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    static boolean flag;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        outer:
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjList = new ArrayList[n + 1];
            visited = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                adjList[i] = new ArrayList<>();
                visited[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjList[a].add(b);
                adjList[b].add(a);
            }
            flag = false;
            for (int i = 0; i < n; i++) {
                if (visited[i] == -1) {
                    dfs(i, 0);
                    if (flag) {
                        sb.append("impossible\n");
                        continue outer;
                    }
                }
            }
            sb.append("possible\n");
        }
        System.out.print(sb);

        br.close();
    }

    static void dfs(int node, int mark) {
        if (flag) {
            return;
        }
        visited[node] = mark;
        for (int c : adjList[node]) {
            if (visited[c] == -1) {
                dfs(c, mark ^ 1);
            } else {
                if (visited[c] == mark) {
                    flag = true;
                    return;
                }
            }
        }
    }
}
