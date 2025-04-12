import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[1000001];
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 1000000; i += 2) {
            visited[i] = true;
        }
        for (int i = 3; i <= 1000; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(i);
            set.add(i);
            int index = i * i;
            while (index <= 1000000) {
                visited[index] = true;
                index += i;
            }
        }
        for (int i = 1001; i <= 1000000; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(i);
            set.add(i);
        }
        int n;
        int size = list.size() >> 1;
        outer:while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int limit = n >> 1;
            for (int i = 0; i <= size; i++) {
                int l = list.get(i);
                if (l > limit) {
                    continue;
                }
                if (set.contains(n - l)) {
                    sb.append(n).append(" = ").append(l).append(" + ").append(n - l).append("\n");
                    continue outer;
                }
            }
        }
        System.out.print(sb);
        br.close();
    }

    static boolean isPrime(int n) {
        if ((n & 1) == 0 || n % 3 == 0) {
            return false;
        }
        int limit = (int) Math.sqrt(n);

        for (int i = 5; i <= limit; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


}
