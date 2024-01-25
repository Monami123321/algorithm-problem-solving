import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int size = 0;
        int front = 0;
        int rear = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                size++;
                arr[rear++] = Integer.parseInt(st.nextToken());
            } else if (cmd.equals("pop")) {
                if (size == 0) {
                    sb.append(-1).append("\n");
                } else {
                    size--;
                    sb.append(arr[front++]).append("\n");
                }
            } else if (cmd.equals("size")) {
                sb.append(size).append("\n");
            } else if (cmd.equals("empty")) {
                if (size == 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (cmd.equals("front")) {
                if (size == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(arr[front]).append("\n");
                }
            } else {
                if (size == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(arr[rear - 1]).append("\n");
                }
            }
        }
        System.out.print(sb);


        br.close();
    }
}
