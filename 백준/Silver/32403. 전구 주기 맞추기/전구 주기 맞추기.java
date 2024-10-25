import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int limit = (int) Math.sqrt(t);
        list.add(0);
        for (int i = 1; i <= limit; i++) {
            if (t % i == 0) {
                list.add(i);
                list.add(t / i);
            }
        }
        list.add(Integer.MAX_VALUE);
        Collections.sort(list);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            int index = Collections.binarySearch(list, now);
            if (index < 0) {
                index = -index - 1;
            }
            cnt += Math.min(Math.abs(list.get(index) - now), Math.abs(list.get(index - 1) - now));
        }
        System.out.println(cnt);
        br.close();
    }
}
