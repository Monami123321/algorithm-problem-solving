import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean flag;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        flag = false;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (flag) {
                break;
            }
            dfs(i, visited, 1);
        }
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

    static void dfs(int node, boolean[] visited, int cnt) {
        if (cnt == 5) {
            flag = true;
            return;
        }
        if (flag) {
            return;
        }
        visited[node] = true;
        for (int n : adjList[node]) {
            if (visited[n]) {
                continue;
            }
            dfs(n, visited, cnt + 1);
        }
        
        visited[node] = false;
    }
}
