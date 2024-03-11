import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(arr, new int[M], new boolean[N], new HashSet<>(), 0);
        System.out.print(sb);
        br.close();
    }

    static void permutation(int[] arr, int[] res, boolean[] visited, HashSet<String> set, int depth) {


        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb2.append(res[i]).append(" ");
            }
            if (set.contains(sb2.toString())) {
                return;
            }
            sb.append(sb2).append("\n");
            set.add(sb2.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (depth > 0 && res[depth - 1] > arr[i]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            res[depth] = arr[i];
            visited[i] = true;
            permutation(arr, res, visited, set, depth + 1);
            visited[i] = false;
        }


    }
}
