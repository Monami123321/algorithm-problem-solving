import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    static int[] visited;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[n + 1][n + 1];
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) {
                break;
            }
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = true;
        }
        adjList = new ArrayList[n + 1];
        visited = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
            visited[i] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (!arr[i][j]) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (flag) {
                break;
            }
            if (visited[i] == -1) {
                dfs(i, 0);
            }
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (flag) {
            sb.append(-1);
        } else {
            sb.append(1).append("\n");
            for (int i = 1; i < n + 1; i++) {
                if (visited[i] == 0) {
                    list1.add(i);
                } else {
                    list2.add(i);
                }
            }

            list1.forEach(e -> sb.append(e).append(" "));
            sb.append(-1).append("\n");
            list2.forEach(e -> sb.append(e).append(" "));
            sb.append(-1).append("\n");

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
