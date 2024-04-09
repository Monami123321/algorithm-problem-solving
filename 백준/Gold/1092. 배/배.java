import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int weight;
        Node next;
        Node prev;

        public Node(int weight) {
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Node[] nodes = new Node[m];
        for (int i = 0; i < m; i++) {
            nodes[i] = new Node(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes, (a, b) -> a.weight - b.weight);
        if (nodes[m - 1].weight > arr[n - 1]) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < m - 1; i++) {
            nodes[i].next = nodes[i + 1];
            nodes[m - 1 - i].prev = nodes[m - 2 - i];
        }
        int t= 0;
        int size = m;
        Node head = nodes[0];
        Node tail = nodes[m - 1];
        Node prevTarget = tail;
        while (size > 0) {
            outer:for (int i = 0; i < n; i++) {
                int now = arr[n - 1 - i];
                if (tail.weight <= now) {
                    if (tail == head) {
                        size--;
                        break;
                    }
                    tail = tail.prev;
                    prevTarget = tail;
                    size--;
                } else {
                    Node target = prevTarget;
                    while (target.weight > now) {
                        if (target == head) {
                            break outer;
                        } else {
                            target = target.prev;
                        }
                    }

                    if (target == head) {
                        head = head.next;
                        prevTarget = head.next;
                        size--;
                    } else {
                        prevTarget = target.prev;
                        target.prev.next = target.next;
                        target.next.prev = target.prev;
                        size--;
                    }
                }

            }
            t++;
        }
        System.out.println(t);
        br.close();
    }
}
