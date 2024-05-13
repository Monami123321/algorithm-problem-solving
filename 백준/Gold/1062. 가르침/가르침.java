import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int BASE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        BASE = 1 << 'a' - 97;
        BASE |= 1 << ('n' - 97);
        BASE |= 1 << ('t' - 97);
        BASE |= 1 << ('i' - 97);
        BASE |= 1 << ('c' - 97);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            int num = BASE;
            for (int j = 4; j < tmp.length - 4; j++) {
                num |= 1 << tmp[j] - 97;
            }
            arr[i] = num;
        }
        int ans = 0;
        for (int i = 0; i < 1 << 26; i++) {
            if ((i & BASE) != BASE || Integer.bitCount(i) != k) {
                continue;
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if ((i & arr[j]) == arr[j]) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
        br.close();
    }
}
