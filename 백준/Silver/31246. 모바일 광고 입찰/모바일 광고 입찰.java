import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int start = 0;
        int end = 1000000000;
        int mid;
        while (start <= end) {
            mid = start + end >> 1;
            int cnt = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (arr[i][0] + mid >= arr[i][1]) {
                    cnt++;
                }
                if (cnt == t) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        br.close();
    }
}
