import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        hm.put(0L, 1L);
        System.out.println(getNum(n, p, q));
        br.close();
    }

    static long getNum(long n, int p, int q) {
        if (n == 0) {
            return 1;
        }
        if (hm.get(n) != null) {
            return hm.get(n);
        }
        long target1 = n / p;
        long target2 = n / q;
        hm.put(n, getNum(target1, p, q) + getNum(target2, p, q));
        return hm.get(n);
    }
}
