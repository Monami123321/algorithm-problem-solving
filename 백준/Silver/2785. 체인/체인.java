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

        int ans = 0;
        int index = n - 1;
        outer:
        for (int i = 0; i < n; i++) {
            if (i == index) {
                break;
            }
            int now = arr[i];
            while (now > 0) {
                now--;
                index--;
                if (index == i) {
                    ans += arr[i] - now;
                    break outer;
                }
            }
            ans += arr[i];
        }
        System.out.println(ans);


        br.close();
    }
}
