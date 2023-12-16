import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int stackPt = 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());

            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                while (stackPt <= target) {
                    stack.push(stackPt++);
                    sb.append("+\n");
                }
                if (stack.isEmpty() || stack.peek() != target) {
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                    sb.append("-\n");
                }
            }


        }
        System.out.print(sb);


    }
}
