import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine(), "RC");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) - 1;
            if (r == 0) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            while (c >= 0) {
                stack.push((char) ((c % 26) + 65));
                c /= 26;
                c -= 1;
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append(r).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
