import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Boolean> q = new Stack<>();
        Stack<Boolean> u = new Stack<>();
        Stack<Boolean> a = new Stack<>();
        Stack<Boolean> c = new Stack<>();
        Queue<Boolean> duck = new LinkedList<>();


        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 'q':
                    if (duck.isEmpty()) {
                        ans++;
                        q.add(true);
                    } else {
                        q.add(true);
                        duck.poll();
                    }
                    break;
                case 'u':
                    if (q.isEmpty()) {
                        System.out.println(-1);
                        return;
                    } else {
                        q.pop();
                        u.add(true);
                    }
                    break;
                case 'a':
                    if (u.isEmpty()) {
                        System.out.println(-1);
                        return;
                    } else {
                        u.pop();
                        a.add(true);
                    }
                    break;
                case 'c':
                    if (a.isEmpty()) {
                        System.out.println(-1);
                        return;
                    } else {
                        a.pop();
                        c.add(true);
                    }
                    break;
                case 'k':
                    if (c.isEmpty()) {
                        System.out.println(-1);
                        return;
                    } else {
                        c.pop();
                        duck.add(true);
                    }
                    break;
            }
        }
        if (!q.isEmpty() || !u.isEmpty() || !a.isEmpty() || !c.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);


        br.close();
    }
}
