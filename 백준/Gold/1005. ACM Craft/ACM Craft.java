import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int no, time;
        List<Node> child;

    }

    static int cal(Node node) {
        if (node.child.size() == 0) {
            if (memo[node.no] == -1) {
                memo[node.no] = node.time;
            }
            return memo[node.no];
        }
        int max = -1;
        for (Node c : node.child) {
            if (memo[c.no] == -1) {
                memo[c.no] = cal(c);
            }
            max = Math.max(max, memo[c.no]);
        }
        if (memo[node.no] == -1) {
            memo[node.no] = max + node.time;
        }

        return memo[node.no];


    }

    static int[] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Node[] nodes = new Node[n + 1];  // 노드가 1번부터
            memo = new int[n + 1];
            Arrays.fill(memo, -1);

            for (int i = 1; i < n + 1; i++) {
                nodes[i] = new Node();

            }
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                nodes[i].time = Integer.parseInt(st.nextToken());
                nodes[i].no = i;
                nodes[i].child = new ArrayList<>();

            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes[y].child.add(nodes[x]); // x를 지어야 y를 지을 수 있음 ㅡ> y 최상단이 루트
            }
            int w = Integer.parseInt(br.readLine());

            sb.append(cal(nodes[w])).append("\n");
        }
        System.out.print(sb);

    }
}
