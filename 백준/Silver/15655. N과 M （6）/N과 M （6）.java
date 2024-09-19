import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] res = new int[m];
        boolean[] visited = new boolean[n];
        permutation(arr, res, visited, 0, m);
        System.out.print(sb);
        br.close();
    }

    static void permutation(int[] arr, int[] res, boolean[] visited, int depth, int m) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (depth > 0 && arr[i] < res[depth - 1]) {
                continue;
            }
            res[depth] = arr[i];
            visited[i] = true;
            permutation(arr, res, visited, depth + 1, m);
            visited[i] = false;
        }

    }
}
