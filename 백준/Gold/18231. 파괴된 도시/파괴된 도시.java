import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] target = new int[k];
        boolean[] visited = new boolean[n + 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            set.add(target[i]);
            set.addAll(adjList[target[i]]);
            visited[target[i]] = true;
        }
        Set<Integer> toBeRemoved = new HashSet<>();
        set.forEach(e -> {
            if (!visited[e]) {
                toBeRemoved.add(e);
                return;
            }
            for (int adj : adjList[e]) {
                if (!visited[adj]) {
                    toBeRemoved.add(e);
                    break;
                }
            }
        });
        set.removeAll(toBeRemoved);
        boolean[] check = new boolean[n + 1];
        set.forEach(e -> {
            check[e] = true;
            adjList[e].forEach(el -> {
                check[el] = true;
            });
        });
        for (int i = 1; i < n + 1; i++) {
            if (check[i] != visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append("\n");
        set.forEach(e -> {
            sb.append(e).append(" ");
        });
        System.out.print(sb);
        br.close();
    }
}
