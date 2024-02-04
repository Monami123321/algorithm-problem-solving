import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        int idx = 0;
        while (k >= 0) {
            long tmp = (long) Math.pow(10, idx++);
            if (k - 9 * tmp * idx >= 0) {
                k -= 9 * tmp * idx;
            } else break;
        }
        if (k == 0) {
            if (N < (long) Math.pow(10, idx - 1) - 1) {
                System.out.println(-1);
                return;
            } else {
                String tmp = String.valueOf((long) Math.pow(10, idx - 1) - 1);
                System.out.println(tmp.charAt(tmp.length() - 1));
                return;
            }
        }
        long target = (long) Math.pow(10, idx - 1) + (k - 1) / (idx);
        if (target > N) System.out.println(-1);
        else {
            int numIdx = (int) (k - 1) % (idx);
            System.out.println(String.valueOf(target).charAt(numIdx));
        }
    }
}