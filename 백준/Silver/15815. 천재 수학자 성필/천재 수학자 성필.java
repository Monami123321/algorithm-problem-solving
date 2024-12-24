import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : br.readLine().toCharArray()) {
            if (c >= '0' && c <= '9') {
                stack.push(c - 48);
            } else {
                if (c == '+') {
                    stack.push(stack.pop() + stack.pop());
                } else if (c == '-') {
                    int tmp = stack.pop();
                    stack.push(stack.pop() - tmp);
                } else if (c == '*') {
                    stack.push(stack.pop() * stack.pop());
                } else {
                    int tmp = stack.pop();
                    stack.push(stack.pop() / tmp);
                }
            }
        }
        System.out.println(stack.pop());
        br.close();
    }
}
