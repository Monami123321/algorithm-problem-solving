import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[1000001];
        List<Integer> list = new ArrayList<>();
        int limit = (int) Math.sqrt(1000000);

        for (int i = 2; i <= limit; i++) {
            if (visited[i]) {
                continue;
            }
            if (isPrime(i)) {
                int index = i;
                list.add(i);
                while (index <= 1000000) {
                    visited[index] = true;
                    index += i;
                }
            }
        }
        for (int i = limit + 1; i <= 1000000; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(i);
        }
        HashSet<Integer> set = new HashSet<>(list);
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int index = 0;
            int cnt = 0;
            while (true) {
                int now = list.get(index++);
                if (now >= n) {
                    break;
                }
                if (set.contains(n - now)) {
                    if (now == n - now) {
                        cnt += 2;
                    } else {
                        ++cnt;
                    }
                }
            }
            sb.append(cnt >> 1).append("\n");
        }
        System.out.print(sb);
        br.close();

    }

    static boolean isPrime(int n) {
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
