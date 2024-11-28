import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        combination(n, m, new boolean[n + 1], 0, 0, sb);
        System.out.print(sb);
        br.close();
    }

    static void combination(int n, int m, boolean[] visited, int depth, int pick, StringBuilder sb) {
        if (pick == m) {
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        if (n == depth) {
            return;
        }
        visited[depth + 1] = true;
        combination(n, m, visited, depth + 1, pick + 1, sb);
        visited[depth + 1] = false;
        combination(n, m, visited, depth + 1, pick, sb);
    }
}
