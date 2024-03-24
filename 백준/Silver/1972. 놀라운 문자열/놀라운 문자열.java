import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) {
                break;
            }
            if (isAmazing(str)) {
                sb.append(str).append(" is surprising.\n");
            } else {
                sb.append(str).append(" is NOT surprising.\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static boolean isAmazing(String str) {
        int len = str.length();
        int delta = 1;
        Set<String> set = new HashSet<>();
        while (delta <= len - 2) {
            int left = 0;
            int right = delta;
            while (right < len) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(left++)).append(str.charAt(right++));
                String now = sb.toString();
                if (set.contains(now)) {
                    return false;
                } else {
                    set.add(now);
                }
            }
            delta++;
            set.clear();
        }
        return true;
    }
}
