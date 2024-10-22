import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }
        int prev = stack.pop();
        int cnt = 0;

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (prev <= now) {
                cnt += now - prev + 1;
                prev--;
            } else {
                prev = now;
            }
        }
        System.out.println(cnt);

        br.close();
    }
}
