import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Trie {
        Node root = new Node();

        void insert(String word) {
            String[] arr = word.split(" ");
            Node cur = root;
            for (int i = 1; i < arr.length; i++) {
                String s = arr[i];
                if (!cur.children.containsKey(s)) {
                    cur.children.put(s, new Node());
                }
                cur = cur.children.get(s);
            }
        }

        void print(int depth, Node node) {
            node.children.keySet().forEach(e -> {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(e).append("\n");
                print(depth + 1, node.children.get(e));
            });

        }
    }

    static class Node {
        TreeMap<String, Node> children = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }
        trie.print(0, trie.root);
        System.out.print(sb);
        br.close();
    }
}
