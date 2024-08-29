import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        int[] arr = new int[n + 1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int child = now[0];
            int parent = now[1];
            if (arr[child] != 0) {
                continue;
            }
            arr[child] = parent;
            adjList[child].forEach(e -> {
                if (arr[e] != 0) {
                    return;
                }
                q.add(new int[]{e, child});
            });
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
