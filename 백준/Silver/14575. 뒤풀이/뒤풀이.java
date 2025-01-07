import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int min = 0;
        int max = 0;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            min += arr[i][0] = Integer.parseInt(st.nextToken());
            max += arr[i][1] = Integer.parseInt(st.nextToken());
            start = Math.min(arr[i][0], start);
            end = Math.max(arr[i][1], end);
        }
        if (max < t || t < min) {
            System.out.println(-1);
            return;
        }
        outer:
        while (start <= end) {
            int mid = start + end >> 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (mid < arr[i][0]) {
                    start = mid + 1;
                    continue outer;
                }
                sum += Math.min(arr[i][1], mid) - arr[i][0];
            }
            if (sum >= t - min) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        br.close();
    }
}
