import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            hashMap.put(tmp, String.valueOf(i));
            hashMap.put(String.valueOf(i), tmp);
        }

        for (int i = 0; i < m; i++) {
            sb.append(hashMap.get(br.readLine())).append("\n");
        }
        System.out.print(sb);
    }
}
