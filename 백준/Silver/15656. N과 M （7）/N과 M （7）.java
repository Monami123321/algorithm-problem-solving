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
        permutation(arr, new int[m], 0, m);
        System.out.print(sb);
        br.close();
    }

    static void permutation(int[] arr, int[] res, int depth, int m) {
        if (depth == m) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == prev) {
                continue;
            }
            prev = res[depth] = arr[i];
            permutation(arr, res, depth + 1, m);
        }
    }
}
