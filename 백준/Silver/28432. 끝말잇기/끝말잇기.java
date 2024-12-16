import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        Set<String> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if (arr[i].equals("?")) {
                index = i;
                continue;
            }
            set.add(arr[i]);
        }
        char s = index == 0 ? '*' : arr[index - 1].charAt(arr[index - 1].length() - 1);
        char e = index == n - 1 ? '*' : arr[index + 1].charAt(0);
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if (set.contains(tmp)) {
                continue;
            }
            if (s != '*' && tmp.charAt(0) != s) {
                continue;
            }
            if (e != '*' && tmp.charAt(tmp.length() - 1) != e) {
                continue;
            }
            System.out.println(tmp);
            return;
        }
        br.close();
    }
}
