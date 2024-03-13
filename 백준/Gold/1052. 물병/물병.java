import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while (true) {
            if (bitCount(n++) <= k) {
                break;
            }
            ++cnt;
        }
        System.out.println(cnt);
        br.close();
    }
    static int bitCount(int n) {
        int cnt = 0;
        while(n > 0) {
            n = (n & n - 1);
            ++cnt;
        }
        return cnt;
    }
}
