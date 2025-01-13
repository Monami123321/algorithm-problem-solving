import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double t = Double.parseDouble(st.nextToken());
        int[][] arr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        double dist = t * arr[1][0];
        double left = arr[0][0] - dist;
        double right = arr[0][0] + dist;
        for (int i = 1; i < n; i++) {
            dist = t * arr[1][i];
            double l = arr[0][i] - dist;
            double r = arr[0][i] + dist;
            left = Math.max(left, Math.round(l * 10000) / 10000.0);
            right = Math.min(right, Math.round(r * 10000) / 10000.0);
            if (left > right) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
        br.close();
    }
}
