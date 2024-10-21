import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Trie {
        Node root = new Node();
        StringBuilder sb = new StringBuilder();


        void insert(String s) {
            String[] arr = s.split("\\\\");
            Node cur = root;
            for (String tmp : arr) {
                if (!cur.children.containsKey(tmp)) {
                    cur.children.put(tmp, new Node());
                }
                cur = cur.children.get(tmp);
            }
        }

        void print(int depth, Node node) {
            node.children.keySet().stream().sorted().forEach(e -> {
                for (int i = 0; i < depth; i++) {
                    sb.append(" ");
                }
                sb.append(e).append("\n");
                print(depth + 1, node.children.get(e));
            });
        }


    }

    static class Node {
        Map<String, Node> children = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }
        trie.print(0, trie.root);
        System.out.print(trie.sb);


        br.close();
    }
}
