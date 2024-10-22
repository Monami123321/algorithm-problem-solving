import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        String[] ref = new String[n];
        for (int i = 0; i < n; i++) {
            ref[i] = br.readLine();
        }
        int index = 0;
        String ans;
        outer:
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append((char) (97 + ((c - 97 + index) % 26)));
            }
            String now = sb.toString();
            for (int i = 0; i < n; i++) {
                if (now.contains(ref[i])) {
                    ans = now;
                    break outer;
                }
            }
            index++;
        }
        System.out.println(ans);
        br.close();
    }
}
