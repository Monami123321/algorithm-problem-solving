import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Trie {
        Node root = new Node();

        boolean insert(String s) {
            Node curr = root;
            for (char c : s.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                if (curr.isEndOfWord) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            if (!curr.children.isEmpty()) {
                return false;
            }
            curr.isEndOfWord = true;
            return true;
        }
    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isEndOfWord;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            Trie trie = new Trie();
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!flag) {
                    br.readLine();
                } else {
                    if (!trie.insert(br.readLine())) {
                        flag = false;
                    }
                }
            }
            sb.append(flag ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
        br.close();
    }
}
