import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        permutation(m, 0, arr, new int[m], sb);
        System.out.print(sb);
        br.close();
    }

    static void permutation(int m, int pick, int[] arr, int[] res, StringBuilder sb) {
        if (pick == m) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (pick > 0 && res[pick - 1] > arr[i]) {
                continue;
            }
            res[pick] = arr[i];
            permutation(m, pick + 1, arr, res, sb);
        }
    }
}
