import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> hm = new HashMap<>();
        while (true) {
            String now = br.readLine();
            if (now == null) {
                break;
            }
            cnt++;
            hm.merge(now, 1, Integer::sum);
        }
        System.out.print(hm.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .map(e -> String.format("%s %.4f", e.getKey(), (double) e.getValue() * 100 / cnt)
                ).collect(Collectors.joining("\n")));
        br.close();
    }
}
