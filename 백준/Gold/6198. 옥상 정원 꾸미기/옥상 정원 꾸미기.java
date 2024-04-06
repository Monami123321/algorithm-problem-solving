import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= now) {
                stack.pop();
            }
            ans += stack.size();
            stack.push(now);
        }
        System.out.println(ans);
        br.close();
    }
}
