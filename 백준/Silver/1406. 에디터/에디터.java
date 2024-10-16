import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        Node prev, next;
        char data;

        public Node() {
        }

        public Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Node head = new Node();
        Node tail = new Node();
        Node now = head;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            now.next = node;
            node.prev = now;
            now = node;
        }
        now.next = tail;
        tail.prev = now;
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L":
                    if (now != head) {
                        now = now.prev;
                    }
                    break;
                case "D":
                    if (now.next != tail) {
                        now = now.next;
                    }
                    break;
                case "B":
                    if (now != head) {
                        now.prev.next = now.next;
                        now.next.prev = now.prev;
                        now = now.prev;
                    }
                    break;
                case "P":
                    Node node = new Node(st.nextToken().charAt(0));
                    now.next.prev = node;
                    node.next = now.next;
                    node.prev = now;
                    now.next = node;
                    now = node;
                    break;
            }
        }
        now = head.next;
        StringBuilder sb = new StringBuilder();
        while (now != tail) {
            sb.append(now.data);
            now = now.next;
        }
        System.out.print(sb);
        br.close();
    }
}

