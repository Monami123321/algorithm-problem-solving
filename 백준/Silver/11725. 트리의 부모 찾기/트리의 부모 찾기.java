import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[n + 1];
        int[] ans = new int[n + 1];


        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
//            System.out.println(now);

            adjList[now].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                visited[e] = true;
                queue.add(e);
                ans[e] = now;
                return;
            });

        }
        for (int i = 2; i < ans.length; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb);


    }
}
