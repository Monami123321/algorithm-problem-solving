import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        outer:
        for (int i = 0; i < n; i++) {
            stack.clear();
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < arr.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(arr[j]);
                } else {
                    if (stack.peek() == arr[j]) {
                        stack.pop();
                    } else {
                        stack.push(arr[j]);
                    }
                }
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
