import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<String, HashSet<String>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();
            if (ring.equals("-")) {
                continue;
            }

            HashSet<String> set = hm.get(ring);

            if (set == null) {
                set = new HashSet<>();
                set.add(name);
                hm.put(ring, set);
            } else {
                set.add(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (HashSet<String> set : hm.values()) {
            if (set.size() != 2) {
                continue;
            }
            cnt++;
            sb.append(String.join(" ", set)).append("\n");
        }
        System.out.println(cnt);
        System.out.print(sb);
        br.close();
    }
}
