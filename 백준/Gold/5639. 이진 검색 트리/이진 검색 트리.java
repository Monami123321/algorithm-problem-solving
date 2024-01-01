import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int id;
        Node left, right, parent;

        public Node(int id) {
            this.id = id;
        }
    }

    static void dfs(Node node) {

        if(node.left != null)
            dfs(node.left);
        if(node.right != null)
            dfs(node.right);
        sb.append(node.id).append("\n");

    }
    static void makeTree(Node node, int nextId) {
        if(node.id > nextId) {
            if(node.left == null) {
                node.left = new Node(nextId);
            } else {
                makeTree(node.left, nextId);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(nextId);
            } else {
                makeTree(node.right, nextId);
            }
        }
    }

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        Node root = new Node(Integer.parseInt(br.readLine()));
        String next;
        while ((next = br.readLine()) != null && !next.equals("")) {
            int nextId = Integer.parseInt(next);
            makeTree(root, nextId);
        }
        dfs(root);
        System.out.print(sb);
        br.close();
    }
}
