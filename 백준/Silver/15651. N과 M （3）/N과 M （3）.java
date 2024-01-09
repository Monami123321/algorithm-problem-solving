import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        permutation(arr, new int[m], sb, 0, 0);
        System.out.print(sb);
        br.close();
    }

    static void permutation(int[] arr, int[] res, StringBuilder sb, int depth, int pick) {
        if (pick == m) {
            for (int i = 0; i < m; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (depth == n) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            res[pick] = arr[i];
            permutation(arr, res, sb, depth + 1, pick + 1);
        }

    }
}
