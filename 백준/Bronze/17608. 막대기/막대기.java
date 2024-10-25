import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 1;
        int max = arr[n - 1];
        while (--n >= 0) {
            if (arr[n] > max) {
                cnt++;
                max = arr[n];
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
