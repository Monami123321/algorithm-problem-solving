import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        Node left, right, parent;
        boolean visited;
    }

    static int N;
    static Node[] nodes;
    static Node last;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        for (int i = 1; i < N + 1; i++) {
            nodes[i] = new Node();
        }
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (left != -1) {
                nodes[now].left = nodes[left];
                nodes[left].parent = nodes[now];
            }
            if (right != -1) {
                nodes[now].right = nodes[right];
                nodes[right].parent = nodes[now];
            }
        }
        inorder(nodes[1]);
        cnt = 0;
        nodes[1].visited = true;
        pseudoInorder(nodes[1]);
        System.out.println(cnt);
        br.close();
    }

    static void inorder(Node node) {
        
        if (node.left != null) {
            inorder(node.left);
        }
        cnt++;
        if (cnt == N) {
            last = node;
        }
        if (node.right != null) {
            inorder(node.right);
        }
    }

    static void pseudoInorder(Node node) {
        if (node.left != null && !node.left.visited) {
            cnt++;
            node.left.visited = true;
            pseudoInorder(node.left);
        } else if (node.right != null && !node.right.visited) {
            cnt++;
            node.right.visited = true;
            pseudoInorder(node.right);
        } else if (node == last) {
            return;
        } else if (node.parent != null) {
            cnt++;
            pseudoInorder(node.parent);
        }
    }
}
