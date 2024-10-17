import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        int[] sum = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            sum[i] = Math.max(0, arr[0][2] - getDist(arr[0][0], arr[0][1], arr[i][0], arr[i][1])) - arr[i][2];
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int dist = getDist(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
                sum[i] -= Math.max(0, arr[j][2] - dist);
                sum[j] -= Math.max(0, arr[i][2] - dist);
            }
        }
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            max = Math.max(max, sum[i]);
        }
        System.out.println(max == 0 ? "IMPOSSIBLE" : max);
        br.close();
    }

    static int getDist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
