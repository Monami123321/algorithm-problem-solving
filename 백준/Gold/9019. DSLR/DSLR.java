import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        char[] data;
        List<Character> list;

        public Node(int data) {
            this.data = getChar(data);
            this.list = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; tc++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            visited[start] = true;
            queue.add(new Node(start));
            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (getNum(now.data) == end) {
                    now.list.forEach(sb::append);
                    sb.append("\n");
                    break;
                }

                int[] delta = {(getNum(now.data) << 1) % 10000, getNum(now.data) == 0 ? 9999 : getNum(now.data) - 1,
                        left(getNum(now.data)), right(getNum(now.data))};
                for (int i = 0; i < 4; i++) {
                    if (delta[i] < 0 || delta[i] >= 10000 || visited[delta[i]]) {
                        continue;
                    }
                    Node next = new Node(delta[i]);
                    next.list.addAll(now.list);
                    if (i == 0) {
                        next.list.add('D');
                    } else if (i == 1) {
                        next.list.add('S');
                    } else if (i == 2) {
                        next.list.add('L');
                    } else {
                        next.list.add('R');
                    }
                    queue.add(next);
                    visited[delta[i]] = true;

                }
            }
        }
        System.out.print(sb);
        br.close();
    }

    static int left(int a) {
        int digit = a / 1000;
        int res = a % 1000;
        return res * 10 + digit;
    }

    static int right(int a) {
        int digit = a % 10;
        int res = a / 10;
        return res + digit * 1000;
    }

    static int getNum(char[] arr) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res *= 10;
            res += arr[i] - 48;
        }
        return res;
    }

    static char[] getChar(int a) {
        char[] res = new char[4];
        for (int i = 0; i < 4; i++) {
            res[3 - i] = (char) ((a % 10) + 48);
            a /= 10;
        }
        return res;
    }

}
