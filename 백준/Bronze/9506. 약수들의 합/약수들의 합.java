import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            list.add(1);
            int sum = 1;
            int limit = (int) Math.sqrt(n);
            for (int i = 2; i <= limit; i++) {
                if (n % i == 0) {
                    list.add(i);
                    list.add(n / i);
                    sum += i;
                    sum += n / i;
                }
            }
            if (sum != n) {
                sb.append(n).append(" is NOT perfect.\n");
            } else {
                sb.append(n)
                        .append(" = ")
                        .append(list.stream().sorted().map(String::valueOf).collect(Collectors.joining(" + ")))
                        .append("\n");
            }
            list.clear();
        }
        System.out.print(sb);
        br.close();
    }

}
