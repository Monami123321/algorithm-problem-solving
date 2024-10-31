import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ans = -1;
        for (int i = arr.length - 1; i >= 2; i--) {
            if (arr[i] < arr[i - 1] + arr[i - 2]) {
                ans = arr[i] + arr[i - 1] + arr[i - 2];
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
