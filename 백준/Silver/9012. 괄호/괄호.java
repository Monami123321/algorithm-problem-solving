import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            if (isValid(br.readLine())) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
            stack.clear();
        }
        System.out.print(sb);
        br.close();
    }
    static boolean isValid(String str) {
        char[] arr = str.toCharArray();
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == '(') {
                stack.push(arr[index]);
            } else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                } else {
                    stack.pop();
                }
            }
            ++index;
        }
        return stack.isEmpty();
    }
}
