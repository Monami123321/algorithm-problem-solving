import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n + 1];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (arr[i]) {
                continue;
            }
            if (isPrime(i)) {
                int index = i + i;
                while (index <= n) {
                    arr[index] = true;
                    index += i;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = k+1; i < n + 1; i++) {
            if (!arr[i]) {
                list.add(i);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            final int now = i;
            if (list.stream().anyMatch(e -> now % e == 0)) {
                continue;
            }
            ans++;
        }
        System.out.println(ans);
        br.close();
    }

    static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
