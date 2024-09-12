import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int target = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n - 1;
        int cnt = 0;
        while (right > left) {
            int val = arr[right] + arr[left];
            if (val == target) {
                cnt++;
                right--;
            } else if (val < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
