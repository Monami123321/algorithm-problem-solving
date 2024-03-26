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
        int t = n / 3;
        int left = n % 3;
        int index = n;
        int ans = 0;
        while (t-- > 0) {
            index -= 3;
            ans += arr[index + 1];
            ans += arr[index + 2];
        }
        while (left-- > 0) {
            index--;
            ans += arr[index];
        }
        System.out.println(ans);

        br.close();
    }
}
