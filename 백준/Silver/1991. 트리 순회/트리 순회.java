import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char id;
        Node left;
        Node right;
        Node parent;
    }

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].id = (char) (65 + i);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Node now = nodes[st.nextToken().charAt(0) - 65];

            int left = st.nextToken().charAt(0) - 65;
            if (left >= 0) {
                now.left = nodes[left];
            }
            int right = st.nextToken().charAt(0) - 65;
            if (right >= 0) {
                now.right = nodes[right];
            }
        }
        preorder(nodes[0]);
        sb.append("\n");
        inorder(nodes[0]);
        sb.append("\n");
        postorder(nodes[0]);

        System.out.print(sb);
        br.close();
    }

    static void preorder(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.id);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        sb.append(node.id);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.id);

    }

}
