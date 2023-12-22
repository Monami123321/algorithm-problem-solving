import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{a, 0});
        while (!queue.isEmpty()) {
            long[] now = queue.poll();
            long val = now[0];
            long time = now[1];
            if (val == b) {
                System.out.println(time + 1);
                return;
            }
            if (val > b) {
                continue;
            }
            queue.add(new long[]{val << 1, time + 1});
            queue.add(new long[]{val * 10 + 1, time + 1});
        }
        System.out.println(-1);


        sc.close();
    }
}
