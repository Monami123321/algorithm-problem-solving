import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        loop:
        while (true) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            if (cost == 0) {
                break;
            }
            int diff = Integer.parseInt(st.nextToken());
            int watt = getWatt(cost);
            int start = 0;
            int end = watt >> 1;
            while (end >= start) {
                int mid = (start + end) >> 1;
                int mine = getCost(mid);
                int others = getCost(watt - mid);
                if (others - mine == diff) {
                    sb.append(mine).append("\n");
                    continue loop;
                }
                if (others - mine < diff) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }

    static int getCost(int n) {
        int res = 0;
        if (n > 1000000) {
            res += (n - 1000000) * 7;
            n = 1000000;
        }
        if (n > 10000) {
            res += (n - 10000) * 5;
            n = 10000;
        }

        if (n > 100) {
            res += (n - 100) * 3;
            n = 100;
        }
        res += n << 1;
        return res;
    }

    static int getWatt(int n) {
        // ~200 ~ 29900 ~4,979,900  5000000 -> 초과 7
        int res = 0;
        if (n > 4979900) {
            res += (n - 4979900) / 7;
            n = 4979900;
        }
        if (n > 29900) {
            res += (n - 29900) / 5;
            n = 29900;
        }
        if (n > 200) {
            res += (n - 200) / 3;
            n = 200;
        }
        res += n >> 1;
        return res;
    }
}
