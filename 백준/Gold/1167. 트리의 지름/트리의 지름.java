import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]>[] adjList;
    static int ans;
    static int next;

    static void dfs(int now, int sum, boolean[] visited) {
        visited[now] = true;
        adjList[now].forEach(e -> {
            if(visited[e[0]]) {
                return;
            }
            dfs(e[0],sum+e[1],visited);
        });
        if (sum > ans) {
            ans = sum;
            next = now;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());

        adjList = new ArrayList[V + 1];
        ans = 0;
        next = 0;
        for (int i = 1; i < V + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < V + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());

                adjList[from].add(new int[]{to, cost});
            }
        }
        dfs(1,0,new boolean[V+1]);
        dfs(next,0,new boolean[V+1]);

        System.out.println(ans);


        br.close();
    }
}
