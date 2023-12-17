import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == i) {
                visited[i] = true;
            }
        }


        for (int i = 1; i < n + 1; i++) {

            if (visited[i]) {
                continue;
            }
            boolean[] check = new boolean[n + 1];
            int start = i;
            int prev = i;
            int next = arr[i];
            Stack<Integer> stack = new Stack<>();
            stack.push(prev);
            check[prev] = true;
            while (true) {
                if (next == start) {
                    while (!stack.isEmpty()) {
                        visited[stack.pop()] = true;
                    }
                    break;
                }
                if (visited[next]) {
                    break;
                }
                if (check[next]) {
                    break;
                }
                check[next] = true;
                prev = next;
                next = arr[next];
                stack.push(prev);


            }

        }

        int cnt = 0;

        for (int i = 1; i < n + 1; i++) {

            if (visited[i]) {
                cnt++;
                sb.append(i).append("\n");
            }

        }

        sb.insert(0, Integer.toString(cnt).concat("\n"));
        System.out.print(sb);


        sc.close();

    }
}
