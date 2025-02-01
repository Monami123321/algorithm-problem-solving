import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        if (r < c) {
            r ^= c;
            c ^= r;
            r ^= c;
        }
        if (w << 1 < s) {
            System.out.println(((long) (r + c) * w));
        } else {
            long l = r - c;
            long ans = (long) c * s;
            if (w > s) {
                ans += (l >> 1) * ((long) s << 1);
                if ((l & 1) != 0) {
                    ans += w;
                }
            } else {
                ans += l * w;
            }
            System.out.println(ans);
        }
        br.close();
    }
}
