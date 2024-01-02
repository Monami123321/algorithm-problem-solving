import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];


        for (int i = 0; i < n; i++) {
            String now = br.readLine();
            int len = now.length();
            for (int j = 0; j < len; j++) {
                arr[now.charAt(j) - 'A'] += (int) Math.pow(10, len - j - 1);
            }
        }
        Arrays.sort(arr);
        int num = 9;
        int ans = 0;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 0) {
                break;
            }
            ans += arr[i] * num--;
        }
        System.out.println(ans);


        br.close();

    }
}
