import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] arr = new int[len + 1];
        arr[1] = 9;
        for (int i = 2; i < len; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i - 1];
            } else {
                arr[i] = arr[i - 1] * 10;
            }
        }
        int cnt = 0;
        for (int i = 1; i < len; i++) {
            cnt += arr[i];
        }

        int n = (int) Math.pow(10, (len >> 1) - 1);
        long limit = Long.parseLong(str);
        if (limit < 10) {
            System.out.println(limit);
            return;
        }
        if ((len & 1) == 0) {
            while (true) {
                StringBuilder sb = new StringBuilder();
                sb.append(n);
                long tmp = Long.parseLong(sb.append(new StringBuilder(sb).reverse()).toString());
                if (tmp > limit) {
                    break;
                }
                cnt++;
                n++;
            }
        } else {
            outer:
            while (true) {
                StringBuilder sb = new StringBuilder();
                sb.append(n);
                for (int i = 0; i < 10; i++) {
                    long tmp = Long.parseLong(new StringBuilder(sb).append(i).append(new StringBuilder(sb).reverse()).toString());
                    if (tmp > limit) {
                        break outer;
                    }
                    cnt++;
                }
                n++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
