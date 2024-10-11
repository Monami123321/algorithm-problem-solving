import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        long ans = Long.parseLong(st.nextToken());
        boolean flag = false;
        long t = 0;
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            if (tmp.equals("-")) {
                if (flag) {
                    ans -= t;
                    t = 0L;
                } else {
                    flag = true;
                    ans += t;
                    t = 0L;
                }
            } else if (tmp.equals("+")) {
                t += Long.parseLong(st.nextToken());
            } else {
                t += Long.parseLong(tmp);
            }
        }
        if (flag) {
            ans -= t;
        } else {
            ans += t;
        }
        System.out.println(ans);

        br.close();
    }
}
