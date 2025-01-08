import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        Node[] child = new Node[128];
        int[] cnt = new int[128];
    }

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
    static int n, m;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        Node root = new Node();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                insert(i, j, 0, root);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String tmp = br.readLine();
            sb.append(search(root, tmp, 0, tmp.length())).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void insert(int r, int c, int depth, Node node) {
        if (depth == 5) {
            return;
        }
        int val = map[r][c];
        if (node.child[val] == null) {
            node.child[val] = new Node();
        }
        node.cnt[val]++;
        node = node.child[val];
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0) {
                nr = n - 1;
            }
            if (nc < 0) {
                nc = m - 1;
            }
            if (nr > n - 1) {
                nr = 0;
            }
            if (nc > m - 1) {
                nc = 0;
            }
            insert(nr, nc, depth + 1, node);
        }
    }

    static int search(Node node, String s, int depth, int len) {
        if (depth == len - 1) {
            return node.cnt[s.charAt(depth)];
        }
        int val = s.charAt(depth);
        if (node.child[val] == null) {
            return 0;
        }
        node = node.child[val];
        return search(node, s, depth + 1, len);
    }

}
