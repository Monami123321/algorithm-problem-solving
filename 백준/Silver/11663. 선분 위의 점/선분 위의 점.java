import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (left > right) {
                left ^= right;
                right ^= left;
                left ^= right;
            }
            left = Arrays.binarySearch(arr, left);
            right = Arrays.binarySearch(arr, right);
            boolean flag = false;
            if (left < 0) {
                left = -left - 1;
            }
            if (right < 0) {
                right = -right - 1;
                flag = true;
            }
            if (left == right) {
                sb.append(0);
            } else {
                if (flag) {
                    sb.append(right - left);
                } else {
                    sb.append(right - left + 1);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
