import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            Map<String, Integer> hm = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                hm.merge(br.readLine().split(" ")[1], 1, Integer::sum);
            }
            sb.append(hm.values().stream().reduce(1, (total, now) -> total * (now + 1)) - 1).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
