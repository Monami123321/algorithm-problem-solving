import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        perm(n, m, 0, new int[m]);
        System.out.print(sb);
        br.close();
    }

    static void perm(int n, int m, int depth, int[] res) {
        if (m == depth) {
            for (int i = 0; i < m; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            res[depth] = i;
            perm(n, m, depth + 1, res);
        }
    }
}


