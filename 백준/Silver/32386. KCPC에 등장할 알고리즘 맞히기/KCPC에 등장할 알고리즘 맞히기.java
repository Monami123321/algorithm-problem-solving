import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                hm.merge(st.nextToken(), 1, Integer::sum);
            }
        }
        List<Map.Entry<String, Integer>> list = hm.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).collect(Collectors.toList());
        Map.Entry<String, Integer> entry = list.get(0);
        if (list.size() > 1 && entry.getValue().intValue() == list.get(1).getValue()) {
            System.out.println(-1);
        } else {
            System.out.println(entry.getKey());
        }
        br.close();
    }
}
