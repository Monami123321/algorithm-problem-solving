import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        void insert(String s) {
            Node cur = this.root;
            for (char c : s.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node());
                }
                cur = cur.children.get(c);
            }
            cur.isEndOfWord = true;
        }

        boolean startsWith(String s) {
            Node curr = this.root;
            for (char c : s.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return true;
        }

    }

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean isEndOfWord;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (trie.startsWith(br.readLine())) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
