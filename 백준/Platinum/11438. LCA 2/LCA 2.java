import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int id, depth;
        Node parent;
        List<Node> child;

        public Node(int id) {
            this.id = id;
            this.child = new ArrayList<>();
        }
    }

    static Node[] nodes;
    static int[][] dp;


    static void dfs(Node node, int parentNode, int depth) {
        node.depth = depth;
        node.parent = nodes[parentNode];
        dp[node.id][0] = parentNode;
        // 2^i 위쪽 노드는 2^i-1 노드의 2^i-1 위쪽이니까
        for (int i = 1; i < dp[0].length; i++) {
            dp[node.id][i] = dp[dp[node.id][i - 1]][i - 1];
        }
        node.child.forEach(n -> {
            dfs(n, node.id, depth + 1);
        });


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n + 1];

        // n이 10만 이하 -> dp테이블 사이즈 정하기
        int tableSize = 17;
        while (true) {
            if ((n & (1 << tableSize)) != 0) {
                break;
            }
            tableSize--;
        }
        // 2^i번쨰 조상 저장 -> 비트연산해서 처음만난 수가 k면, k번밀었더니 1을 만남 -> 0부터 2^k+1 조상까지 필요함 -> tablesize+2
        dp = new int[n + 1][tableSize + 2];

//        for (int i = 0; i < tableSize + 1; i++) {
//            dp[1][i] = 1; // 루트의 조상은 루트로
//
//        }


        for (int i = 1; i < n + 1; i++) {
            nodes[i] = new Node(i);
        }

        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        // 전처리 마무리

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            adjList[now].forEach(e -> {
                if (visited[e]) {
                    return;
                }
                queue.add(e);
                visited[e] = true;
                nodes[now].child.add(nodes[e]);
                nodes[e].parent = nodes[now];
            });
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i] = 1;
        }
        dfs(nodes[1], 1, 0);


        // 쿼리 시작
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Node a = nodes[Integer.parseInt(st.nextToken())];
            Node b = nodes[Integer.parseInt(st.nextToken())];


            // 두번쓰기 귀찮으니까 a가 깊은애로 고정
            if (a.depth < b.depth) {
                Node tmp = a;
                a = b;
                b = tmp;
            }

            int diff = a.depth - b.depth;
            // 두 노드 깊이 똑같게 조정하기
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // 점프 얼마나 뛸지 결정
                if ((diff & (1 << j)) != 0) {
                    a = nodes[dp[a.id][j]];
                }
            }

            // 깊이 조절 끝 -> 같이 올려보기
            // 첨으로 조상이 같지 않을 때까지 인덱스를 내리고 점프 -> 0까지 반복
            // 근데 a==b가 됐으면 한 번 처리
            if (a.id == b.id) {
                sb.append(a.id).append("\n");
                continue;
            }


            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (dp[a.id][j] != dp[b.id][j]) {
                    a = nodes[dp[a.id][j]];
                    b = nodes[dp[b.id][j]];
                }

            }
            // 그럼 바로 위가 LCA임
            sb.append(dp[a.id][0]).append("\n");
        }

        System.out.print(sb);


        br.close();
    }
}
