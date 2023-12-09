import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;

    }

    static TreeSet<Integer> set;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        set = new TreeSet<>();

        boolean[] arr = new boolean[10000];
        for (int i = 2; i <= Math.sqrt(9999); i++) {
            if (arr[i]) {
                continue;
            }
            if (isPrime(i)) {
                int next = i * 2;
                while (next <= 9999) {
                    arr[next] = true;
                    next += i;
                }
            }
        }
        for (int i = 1000; i <= 9999; i++) {
            if (!arr[i]) {
                set.add(i);
            }

        }
        // set에 소수만 모아짐


        int testCases = Integer.parseInt(br.readLine());
        tc:
        for (int tc = 0; tc < testCases; tc++) {
            boolean[] visited = new boolean[10000];
            set.forEach(a -> visited[a] = true); // 소수만 true로 칠해둠 방문을 거꾸로 처리하면 됨
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start, 0});
            visited[start] = false;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[0] == end) {
                    sb.append(now[1]).append("\n");
                    continue tc;
                }
                int firstDigit = now[0] / 1000;
                int secondDigit = (now[0] % 1000) / 100;
                int thirdDigit = (now[0] % 100) / 10;
                int lastDigit = now[0] % 10;

                for (int i = 1; i < 10; i++) {
                    if (i == firstDigit)
                        continue;
                    int next = (now[0] % 1000) + i * 1000;
                    if (!visited[next]) {
                        continue;
                    }
                    queue.add(new int[]{next, now[1] + 1});
                    visited[next] = false;
                }
                for (int i = 0; i < 10; i++) {
                    if (i == secondDigit)
                        continue;
                    int next = now[0] - secondDigit * 100 + i * 100;
                    if (!visited[next]) {
                        continue;
                    }
                    queue.add(new int[]{next, now[1] + 1});
                    visited[next] = false;
                }
                for (int i = 0; i < 10; i++) {
                    if (i == thirdDigit)
                        continue;
                    int next = now[0] - thirdDigit * 10 + i * 10;
                    if (!visited[next]) {
                        continue;
                    }
                    queue.add(new int[]{next, now[1] + 1});
                    visited[next] = false;
                }
                for (int i = 0; i < 10; i++) {
                    if (i == lastDigit)
                        continue;
                    int next = now[0] - lastDigit + i;
                    if (!visited[next]) {
                        continue;
                    }
                    queue.add(new int[]{next, now[1] + 1});
                    visited[next] = false;
                }

            }
            sb.append("Impossible\n");


        }
        System.out.print(sb);

    }
}
