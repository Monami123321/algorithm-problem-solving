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
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int tip = arr[n - 1 - i] - i;
            if (tip <= 0) {
                break;
            }
            ans += tip;
        }
        System.out.println(ans);


        br.close();
    }
}
