import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        combination(0, 0, new boolean[n]);
        System.out.print(sb);

    }

    static void combination(int depth, int pick, boolean[] visited) {
        if (pick == m) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sb.append(i + 1).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        if (depth == n) {
            return;
        }
        visited[depth] = true;
        pick++;
        combination(depth + 1, pick, visited);
        visited[depth] = false;
        pick--;
        combination(depth + 1, pick, visited);
    }
}
