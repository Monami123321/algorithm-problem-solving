import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n + 3];

        for (int i = 0; i < 2; i++) {
            Arrays.fill(arr[i], 1 << 28);
            arr[i][1] = 0;
        }


        int[] small = new int[n + 1];
        int[] big = new int[n + 1];

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            arr[0][i + 1] = Math.min(arr[0][i + 1], arr[0][i] + small[i]);
            arr[0][i + 2] = Math.min(arr[0][i + 2], arr[0][i] + big[i]);

            arr[1][i + 1] = Math.min(arr[1][i + 1], arr[1][i] + small[i]);
            arr[1][i + 2] = Math.min(arr[1][i + 2], arr[1][i] + big[i]);

            arr[1][i + 3] = Math.min(arr[1][i + 3], arr[0][i] + k);
        }
        System.out.print(Math.min(arr[0][n], arr[1][n]));
        br.close();
    }
}
