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
        perm(arr, new int[m], m, 0, 0);
        System.out.print(sb);
        br.close();
    }

    static void perm(int[] arr, int[] res, int m, int depth, int flag) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int tmp = 1 << i;
            if ((flag & tmp) != 0) {
                continue;
            }
            flag |= tmp;
            res[depth] = arr[i];
            perm(arr, res, m, depth + 1, flag);
            flag ^= tmp;
        }
    }
}