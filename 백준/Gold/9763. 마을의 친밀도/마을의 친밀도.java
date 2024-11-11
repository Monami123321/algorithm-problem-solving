import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 1 << 29;
        for (int i = 0; i < n; i++) {
            int d1 = Integer.MAX_VALUE;
            int d2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int tmp = getDist(arr[i], arr[j]);
                if (d1 > tmp) {
                    d1 ^= tmp;
                    tmp ^= d1;
                    d1 ^= tmp;
                }
                if (d2 > tmp) {
                    d2 ^= tmp;
                    tmp ^= d2;
                    d2 ^= tmp;
                }
            }
            ans = Math.min(ans, d1 + d2);
        }
        System.out.println(ans);
        br.close();
    }


    static int getDist(int[] arr1, int[] arr2) {
        return Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[1] - arr2[1]) + Math.abs(arr1[2] - arr2[2]);
    }

}
