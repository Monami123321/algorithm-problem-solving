import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());

            for (int j = 0; j < tmp; j++) {
                hm.merge(Long.parseLong(st.nextToken()), 1, Integer::sum);
            }
            List<Map.Entry<Long, Integer>> list = hm.entrySet().stream().sorted(Comparator.comparingInt(a -> -a.getValue())).collect(Collectors.toList());
            Map.Entry<Long, Integer> entry = list.get(0);
            if (entry.getValue() > (tmp >> 1)) {
                sb.append(entry.getKey()).append("\n");
            } else {
                sb.append("SYJKGW\n");
            }
            hm.clear();
        }
        System.out.print(sb);
        br.close();
    }
}
