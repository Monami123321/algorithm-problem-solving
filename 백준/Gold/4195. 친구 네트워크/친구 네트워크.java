import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        String name;
        int id;
        int size;
        Node parent;

        public Node(String name, int id, int size) {
            this.name = name;
            this.id = id;
            this.size = size;
            this.parent = this;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("untitled\\src\\data.txt"));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; ++tc) {
            int f = Integer.parseInt(br.readLine());
            Map<String, Node> hm = new HashMap<>();
            int index = 0;
            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                Node node1 = hm.get(name1);
                if (node1 == null) {
                    node1 = new Node(name1, index++, 1);
                    hm.put(name1, node1);
                }

                Node node2 = hm.get(name2);
                if (node2 == null) {
                    node2 = new Node(name2, index++, 1);
                    hm.put(name2, node2);
                }
                sb.append(union(node1, node2)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static int union(Node a, Node b) {
        Node parentA = findSet(a);
        Node parentB = findSet(b);
        if (parentA == parentB) {
            return parentA.size;
        }
        if (a.id < b.id) {
            parentB.parent = parentA;
            parentA.size += parentB.size;
//            parentB.size = parentA.size;
//            a.size = parentA.size;
//            b.size = parentA.size;
            return parentA.size;
        } else {
            parentA.parent = parentB;
            parentB.size += parentA.size;
//            parentA.size = parentB.size;
//            a.size = parentB.size;
//            b.size = parentB.size;
            return parentB.size;
        }
//        return a.size;
    }

    static Node findSet(Node a) {
        if (a.parent != a) {
            return a.parent = findSet(a.parent);
        }
        return a;
    }

}
