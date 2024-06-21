import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[0] = arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt == i) {
                arr[i] = 1;
                continue;
            }
            int limit = i >> 1;
            arr[i] = arr[i - 1] + 1;
            for (int j = 1; j <= limit; j++) {
                arr[i] = Math.min(arr[i], arr[j] + arr[i - j]);
            }
        }
        System.out.println(arr[n]);
        br.close();
    }
}
