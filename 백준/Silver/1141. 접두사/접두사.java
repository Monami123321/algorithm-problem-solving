import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            String pre = arr[i];
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (isPrefix(pre, arr[j])) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }

    static boolean isPrefix(String pre, String target) {
        if (target.substring(0, pre.length()).equals(pre)) {
            return true;
        }
        return false;
    }
}
