import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int max, min;

        public Node(int max, int min) {
            this.max = max;
            this.min = min;
        }

        public Node() {
            this.min = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            nodes[i] = new Node(tmp, tmp);
        }

        int startIndex = 1;
        while (startIndex < n) {
            startIndex <<= 1;
        }
        int treeSize = startIndex << 1;
        Node[] segTree = new Node[treeSize];

        for (int i = 0; i < n; i++) {
            segTree[startIndex + i] = nodes[i];
        }
        for (int i = treeSize - 1; i > 1; i--) {
            if (segTree[i] == null) {
                continue;
            }
            if (segTree[i >> 1] == null) {
                segTree[i >> 1] = new Node();
            }
            segTree[i >> 1].max = Math.max(segTree[i].max, segTree[i >> 1].max);
            segTree[i >> 1].min = Math.min(segTree[i].min, segTree[i >> 1].min);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1 + startIndex;
            int right = Integer.parseInt(st.nextToken()) - 1 + startIndex;

            int max = 0;
            int min = Integer.MAX_VALUE;
            while (right > left) {
                if ((left & 1) == 0) {
                    left >>= 1;
                } else {
                    max = Math.max(max, segTree[left].max);
                    min = Math.min(min, segTree[left++].min);
                    left >>= 1;
                }

                if ((right & 1) != 0) {
                    right >>= 1;

                } else {
                    max = Math.max(max, segTree[right].max);
                    min = Math.min(min, segTree[right--].min);
                    right >>= 1;
                }
            }
            if (right == left) {
                max = Math.max(max, segTree[left].max);
                min = Math.min(min, segTree[left].min);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
