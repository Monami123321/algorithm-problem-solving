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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] degree = new int[n + 1];

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();

        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            degree[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            ans[i] = 1;

        }
        int t = 1;
        while (true) {
            for (int i = 1; i < n + 1; i++) {
                if (degree[i] == 0) {
                    queue.add(i);
                    ans[i] = t;
                }
            }
            if (queue.isEmpty()) {
                break;
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();

                adjList[now].forEach(e -> {
                    degree[e]--;
                });
                degree[now] = Integer.MAX_VALUE;
            }
            t++;
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.print(sb);


        br.close();
    }
}
