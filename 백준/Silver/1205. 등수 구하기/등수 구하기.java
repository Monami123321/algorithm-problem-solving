import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if (n == 0) {
            System.out.println(1);
            return;
        }
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] arr = new int[p];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (p == n && arr[p - 1] >= score) {
            System.out.println(-1);
            return;
        }
        int start = 0;
        int end = p - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        if (end == -1) {
            System.out.println(1);
            return;
        }
        end++;
        while (end > 0 && score == arr[end - 1]) {
            end--;
        }
        System.out.println(end + 1);

        br.close();
    }
}
