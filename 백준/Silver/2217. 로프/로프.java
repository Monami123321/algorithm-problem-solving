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
        int ans = arr[n - 1];
        int pointer = n - 1;
        int num = 1;
        while (pointer >= 0) {
            int sum = arr[pointer--] * num++;
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);

        br.close();
    }
}
