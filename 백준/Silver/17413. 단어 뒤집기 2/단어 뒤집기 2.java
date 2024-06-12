import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '<') {
                while (i < arr.length && arr[i] != '>') {
                    ++i;
                }
            } else {
                int index = i;
                while (index < arr.length && arr[index] != ' ' && arr[index] != '<') {
                    stack.push(arr[index++]);
                }
                while (!stack.isEmpty()) {
                    arr[i++] = stack.pop();
                }
                if (i < arr.length && arr[i] == '<') {
                    --i;
                }
            }
        }
        System.out.print(arr);
        br.close();
    }
}
