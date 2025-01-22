import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0, 0, arr, new boolean[n + 1]);
        System.out.println(ans);
        br.close();
    }

    static void dfs(int depth, int g, int sum, int[] arr, boolean[] visited) {
        if (g > m) {
            return;
        }
        if (g == m) {
            ans = Math.max(sum, ans);
        }
        if (depth == n) {
            return;
        }
        visited[depth + 1] = true;
        if (visited[depth]) {
            dfs(depth + 1, g, sum + arr[depth], arr, visited);
        }
        dfs(depth + 1, g + 1, sum + arr[depth], arr, visited);
        visited[depth + 1] = false;
        dfs(depth + 1, g, sum, arr, visited);
    }
}
