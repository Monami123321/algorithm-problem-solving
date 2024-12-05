import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        String name;
        long val;
        String[] parent;

        public Node(String name) {
            this.name = name;
            this.parent = new String[2];
        }
    }

    static Map<String, Node> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node root = new Node(br.readLine());
        root.val = 1L << 60;
        hm = new HashMap<>();
        hm.put(root.name, root);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Node node = new Node(st.nextToken());
            hm.put(node.name, node);
            for (int j = 0; j < 2; j++) {
                node.parent[j] = st.nextToken();
            }
        }
        long score = -1;
        String ans = null;
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            long val = getVal(hm.get(name));
            if (getVal(hm.get(name)) > score) {
                ans = name;
                score = val;
            }
        }
        System.out.println(ans);
        br.close();
    }

    static long getVal(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.val != 0) {
            return node.val;
        }
        return node.val = (getVal(hm.get(node.parent[0])) >> 1) + (getVal(hm.get(node.parent[1])) >> 1);
    }

}

