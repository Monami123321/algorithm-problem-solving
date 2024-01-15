import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= testCases; tc++) {
            st = new StringTokenizer(br.readLine());
            int testCase = Integer.parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            list.add(Integer.parseInt(st.nextToken()));
            int ans = 0;
            outer:
            for (int i = 1; i <= 19; i++) {
                int now = Integer.parseInt(st.nextToken());
                for (int j = 0; j < i; j++) {
                    if (list.get(j) > now) {
                        list.add(j, now);
                        ans += i - j;
                        continue outer;
                    }
                }
                list.addLast(now);
            }
            sb.append(testCase).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
