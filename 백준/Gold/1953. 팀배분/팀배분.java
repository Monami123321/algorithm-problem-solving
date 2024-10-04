import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int[] visited;
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        visited = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
            visited[i] = -1;
        }
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == -1) {
                dfs(i, 0);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                cnt++;
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        sb.append(cnt).append("\n");
        sb.append(list1.stream().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
        sb.append(n - cnt).append("\n");
        sb.append(list2.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(sb);
        br.close();
    }

    static void dfs(int node, int mark) {
        visited[node] = mark;
        for (int c : adjList[node]) {
            if (visited[c] == -1) {
                dfs(c, mark ^ 1);
            }
        }
    }
}
