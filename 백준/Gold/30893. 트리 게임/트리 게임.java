import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Integer> route = new ArrayList<>();
    static List<Integer> list;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        visited = new boolean[n + 1];
        dfs(s, e);
        int size = list.size();
        boolean flag = true;
        for (int i = 1; i < size - 1; i += 2) {
            int now = list.get(i);
            if (adjList[now].size() > 2) {
                flag = false;
                break;
            }
        }
        System.out.print(flag ? "First" : "Second");

        br.close();
    }

    static void dfs(int v, int e) {
        visited[v] = true;
        route.add(v);
        if (v == e) {
            list = new ArrayList<>(route);
            return;
        }

        adjList[v].forEach(el -> {
            if (visited[el]) {
                return;
            }
            dfs(el, e);
        });
        route.remove(route.size() - 1);
    }
}
