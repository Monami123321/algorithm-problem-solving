import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(arr, (a, b) -> {
                double tmpA = (double) a[0] / a[1];
                double tmpB = (double) b[0] / b[1];
                if (tmpA > tmpB) {
                    return -1;
                } else if (tmpA == tmpB) {
                    return a[1] - b[1];
                } else {
                    return 1;
                }
            });
            sb.append(arr[0][1]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
