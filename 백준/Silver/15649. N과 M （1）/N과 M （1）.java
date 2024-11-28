import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        perm(n, m, 0, new int[m], new boolean[n + 1], sb);
        System.out.print(sb);
        br.close();
    }

    static void perm(int n, int m, int depth, int[] res, boolean[] visited, StringBuilder sb) {
        if (depth == m) {
            for (int c : res) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            res[depth] = i;
            visited[i] = true;
            perm(n, m, depth + 1, res, visited, sb);
            visited[i] = false;
        }
    }
}
