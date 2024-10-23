import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] ref = br.readLine().toCharArray();
        int len = ref.length;
        char end = ref[len - 1];

        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            stack.push(c);
            if (c == end) {
                int size = stack.size();
                if (size < len) {
                    continue;
                }
                boolean flag = true;
                for (int i = 0; i < len; i++) {
                    if (stack.get(size - 1 - i) != ref[len - 1 - i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int i = 0; i < len; i++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            System.out.println(sb.reverse());
        }
        br.close();
    }
}
