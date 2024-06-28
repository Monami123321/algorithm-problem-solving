import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        if (arr[0] == 48) {
            System.out.println(0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            int now = arr[i] - 48;
            int cnt = 0;
            while (now > 0) {
                sb.append(now % 2);
                now >>= 1;
                ++cnt;
            }
            while (cnt++ < 3) {
                sb.append(0);
            }
        }
        sb.reverse();
        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
        br.close();
    }
}
