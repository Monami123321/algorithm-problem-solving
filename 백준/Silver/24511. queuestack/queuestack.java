import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            flag[i] = st.nextToken().equals("0");
        }
        st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else {
                st.nextToken();
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
            sb.append(queue.poll()).append(" ");
        }
        System.out.print(sb);


        br.close();
    }
}
