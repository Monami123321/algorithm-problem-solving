import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Integer> hm = new HashMap<>();
    static Map<Integer, Integer> qm = new HashMap<>();

    static {
        hm.put("kor", 1);
        hm.put("eng", 2);
        hm.put("math", 4);
        hm.put("apple", 8);
        hm.put("pear", 16);
        hm.put("orange", 32);
        hm.put("red", 64);
        hm.put("blue", 128);
        hm.put("green", 256);
        hm.put("-", 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = hm.get(st.nextToken());
            int b = hm.get(st.nextToken());
            int c = hm.get(st.nextToken());
            update(a, b, c);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = hm.get(st.nextToken()) | hm.get(st.nextToken()) | hm.get(st.nextToken());
            sb.append(qm.getOrDefault(q, 0)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void update(int a, int b, int c) {
        qm.merge(0, 1, Integer::sum);
        qm.merge(a, 1, Integer::sum);
        qm.merge(b, 1, Integer::sum);
        qm.merge(c, 1, Integer::sum);
        qm.merge(a | b, 1, Integer::sum);
        qm.merge(a | c, 1, Integer::sum);
        qm.merge(b | c, 1, Integer::sum);
        qm.merge(a | b | c, 1, Integer::sum);
    }
}
