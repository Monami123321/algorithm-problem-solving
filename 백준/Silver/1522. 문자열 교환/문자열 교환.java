import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') {
                cnt++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tmp = 0;
            for (int j = i; j < i + cnt; j++) {
                if (arr[j % arr.length] == 'b') {
                    tmp++;
                }
            }
            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
        br.close();
    }
}
