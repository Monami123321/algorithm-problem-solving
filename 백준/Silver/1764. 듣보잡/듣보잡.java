import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        int cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if (set.contains(tmp)) {
                list.add(tmp);
                cnt++;
            }
        }
        list.stream().sorted().forEach(e -> {
            sb.append(e).append("\n");
        });
        System.out.println(cnt);
        System.out.print(sb);

        br.close();
    }
}
