import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int start = 0;
        int end = 5000000;
        while (start <= end) {
            int mid = start + end >> 1;
            long sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += (long) ((mid / arr[i][0]) + 1) * arr[i][1];
            }
            if (sum < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
