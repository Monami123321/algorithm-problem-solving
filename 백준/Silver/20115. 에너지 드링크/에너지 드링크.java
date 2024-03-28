import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Double> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(st.nextToken()));
        }
        Collections.sort(list);
        double ans = list.get(n - 1);

        while (list.size() > 1) {
            ans += list.remove(0) / 2;
        }
        System.out.println(ans);
        br.close();
    }
}
