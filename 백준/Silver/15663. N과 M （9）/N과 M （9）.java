import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(arr, new int[M], new boolean[N], 0, 0);
        StringBuilder sb = new StringBuilder();
        set.forEach(e -> {
            sb.append(e);
        });
        System.out.print(sb);

        br.close();
    }

    static void permutation(int[] arr, int[] res, boolean[] visited, int pick, int depth) {
        if (pick == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {

                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            set.add(sb.toString());
            return;
        }
        if (depth == N) {
            return;
        }


        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            res[pick] = arr[i];
            permutation(arr, res, visited, pick + 1, depth + 1);
            visited[i] = false;
        }


    }
}
