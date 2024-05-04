import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("\\.");
            int now = 0;
            for (int j = 0; j < 4; j++) {
                now <<= 8;
                now += Integer.parseInt(tmp[j]);
            }
            arr[i] = now;
        }
        int limit = 0;
        outer:
        for (int i = 31; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if ((arr[j] & 1 << i) == (arr[j - 1] & 1 << i)) {
                    continue;
                }
                limit = i + 1;
                break outer;
            }
        }
        int mask = 0;
        for (int i = 31; i >= limit; i--) {
            mask |= (1 << i);
        }
        int addr = arr[0] & mask;
        StringBuilder sb = new StringBuilder();
        sb.append(getIPaddr(addr)).append("\n");
        sb.append(getIPaddr(mask));
        System.out.print(sb);
        br.close();

    }

    static String getIPaddr(int n) {
        int ref = 255;
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[3 - i] = (n & ref);
            n >>= 8;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(arr[i]).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
