import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] segTree;
    static boolean[] lazyExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        segTree = new int[n << 2];
        lazyExist = new boolean[n << 2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                update(1, 0, n - 1, l - 1, r - 1);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, n - 1, l - 1, r - 1)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static int update(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (nodeRight < left || nodeLeft > right) {
            return segTree[node];
        }
        if (left <= nodeLeft && nodeRight <= right) {
            if (lazyExist[node]) {
                lazyExist[node] = false;
                return segTree[node] = nodeRight - nodeLeft + 1 - segTree[node];
            }
            lazyExist[node] = true;
            return segTree[node] = nodeRight - nodeLeft + 1 - segTree[node];
        }
        int mid = nodeLeft + nodeRight >> 1;
        if (lazyExist[node]) {
            pushDown(node << 1, nodeLeft, mid);
            pushDown(node << 1 | 1, mid + 1, nodeRight);
            lazyExist[node] = false;
        }
        int leftVal = update(node << 1, nodeLeft, mid, left, right);
        int rightVal = update(node << 1 | 1, mid + 1, nodeRight, left, right);
        return segTree[node] = leftVal + rightVal;
    }

    static void pushDown(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            segTree[node] ^= 1;
            return;
        }
        lazyExist[node] = !lazyExist[node];
        segTree[node] = nodeRight - nodeLeft + 1 - segTree[node];
    }

    static int query(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (nodeRight < left || right < nodeLeft) {
            return 0;
        }
        if (left <= nodeLeft && nodeRight <= right) {
            return segTree[node];
        }

        int mid = nodeLeft + nodeRight >> 1;
        if (lazyExist[node]) {
            pushDown(node << 1, nodeLeft, mid);
            pushDown(node << 1 | 1, mid + 1, nodeRight);
            lazyExist[node] = false;
        }
        int leftVal = query(node << 1, nodeLeft, mid, left, right);
        int rightVal = query(node << 1 | 1, mid + 1, nodeRight, left, right);
        return leftVal + rightVal;
    }


}
