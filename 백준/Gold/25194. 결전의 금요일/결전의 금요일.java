import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] prev = new boolean[8];
        boolean[] next = new boolean[8];
        boolean[] tmp;
        prev[0] = true;
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken()) % 7;
            next[val] = true;
            for (int j = 0; j < 8; j++) {
                if (prev[j]) {
                    next[j] = next[(j + val) % 7] = true;
                }
            }
            tmp = prev;
            prev = next;
            next = tmp;
            Arrays.fill(next, false);
        }
        if (prev[4]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }
}
