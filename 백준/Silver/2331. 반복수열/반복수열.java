import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        HashSet<Long> set = new HashSet<>();
        Stack<Long> stack = new Stack<>();
        while (!set.contains(n)) {
            set.add(n);
            stack.push(n);
            n = getNum(n, p);
        }
        while (!stack.isEmpty() && stack.peek() != n) {
            stack.pop();
        }
        System.out.println(stack.size() - 1);
        br.close();
    }

    static long getNum(long now, int p) {
        long res = 0;
        while (now > 0) {
            res += (long) Math.pow(now % 10, p);
            now /= 10;
        }
        return res;
    }
}
