import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        long target = d - m;
        long start = 0;
        long end = 1L << 31;
        while (start <= end) {
            long mid = start + end >> 1;
            long sum = getSum(mid);
            if (target <= sum) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        br.close();
    }

    static long getSum(long n) {
        if (n <= 2) {
            return n;
        }
        if ((n & 1) == 0) {
            n >>= 1;
            return n * (n + 1);
        }
        n >>= 1;
        return n * (n + 1) + n + 1;
    }
}
