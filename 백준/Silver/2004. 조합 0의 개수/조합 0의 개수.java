import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt2 = Math.max(0, getCnt(n, 2) - getCnt(m, 2) - getCnt(n - m, 2));
        int cnt5 = Math.max(0, getCnt(n, 5) - getCnt(m, 5) - getCnt(n - m, 5));
        System.out.println(Math.min(cnt2, cnt5));
        br.close();
    }

    static int getCnt(int ref, int target) {
        int cnt = 0;
        while (ref >= target) {
            cnt += ref / target;
            ref /= target;
        }
        return cnt;
    }
}
