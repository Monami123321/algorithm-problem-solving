import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer>[] adjList;
    static int[] visited;
    static int[] res = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (arr[j] == '1') {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!adjList[i].isEmpty() && visited[i] == -1) {
                dfs(i, 0);
                cnt += Math.max(res[0], res[1]);
                res[0] = res[1] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    static void dfs(int node, int mark) {
        visited[node] = mark;
        res[mark]++;
        for (int c : adjList[node]) {
            if (visited[c] == -1) {
                dfs(c, mark ^ 1);
            }
        }
    }
}
