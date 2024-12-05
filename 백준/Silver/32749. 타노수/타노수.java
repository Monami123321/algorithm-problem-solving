import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int len = 1 << n - t;
        String str = br.readLine();
        int strLen = str.length();
        String ans = "0";

        for (int i = 0; i <= strLen - len; i += len) {
            String tmp = str.substring(i, i + len);
            if (ans.compareTo(tmp) < 0) {
                ans = tmp;
            }
        }
        System.out.println(ans);

        br.close();
    }
}
