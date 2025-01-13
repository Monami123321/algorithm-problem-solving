import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        int strLen = arr[0].length();

        int len = input.length();
        outer:
        while (true) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String tmp = arr[i].substring(strLen - len);
                if (set.contains(tmp)) {
                    len++;
                    continue outer;
                }
                set.add(tmp);
            }
            System.out.println(len);
            break;
        }
        br.close();
    }
}
