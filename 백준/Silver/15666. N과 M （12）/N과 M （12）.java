import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

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
        sb = new StringBuilder();
        Arrays.sort(arr);
        permutation(arr, new int[m], 0, m);
        System.out.print(sb);
        br.close();
    }

    static void permutation(int[] arr, int[] res, int pick, int r) {
        if (pick == r) {
            for (int i = 0; i < r; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == prev) {
                continue;
            }
            if (pick > 0 && arr[i] < res[pick - 1]) {
                continue;
            }
            prev = arr[i];
            res[pick] = arr[i];
            permutation(arr, res, pick + 1, r);
        }
    }
}
