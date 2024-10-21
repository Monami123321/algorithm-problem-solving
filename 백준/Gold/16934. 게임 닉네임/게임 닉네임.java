import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Trie {
        Node root = new Node();

        String insert(String s) {
            Node cur = root;
            String res = null;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node());
                    if (res == null) {
                        res = s.substring(0, i + 1);
                    }
                }
                cur = cur.children.get(c);
            }
            cur.cnt++;
            if (res == null) {
                if (cur.cnt == 1) {
                    return s;
                }
                return s + cur.cnt;
            }
            return res;
        }
    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        int cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(trie.insert(br.readLine())).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

