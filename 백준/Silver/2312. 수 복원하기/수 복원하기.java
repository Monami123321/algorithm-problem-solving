import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[100001];
        double limit = Math.sqrt(100_000);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (arr[i]) {
                continue;
            }
            if (isPrime(i)) {
                int index = i;
                list.add(i);
                while (index <= 100000) {
                    arr[index] = true;
                    index += i;
                }
            }
        }
        for (int i = (int) limit; i <= 100000; i++) {
            if (!arr[i]) {
                list.add(i);
            }
        }

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            int index = 0;
            while (n > 1) {
                int prime = list.get(index++);
                if (n % prime == 0) {
                    int cnt = 0;
                    while (n % prime == 0) {
                        cnt++;
                        n /= prime;
                    }
                    sb.append(prime).append(" ").append(cnt).append("\n");
                }
            }
        }
        System.out.print(sb);

        br.close();
    }

    static boolean isPrime(int n) {
        double limit = Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
