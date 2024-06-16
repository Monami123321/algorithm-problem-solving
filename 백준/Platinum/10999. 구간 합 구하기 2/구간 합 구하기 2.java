import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] segTree;
    static long[] lazy;
    static boolean[] lazyExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        segTree = build(arr);
        lazy = new long[segTree.length];
        lazyExist = new boolean[segTree.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                long val = Long.parseLong(st.nextToken());
                update(1, 0, n - 1, left, right, val);
            } else {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(1, 0, n - 1, left, right)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static long[] build(long[] arr) {
        long[] res = new long[arr.length << 2];
        build(res, arr, 1, 0, arr.length - 1);
        return res;
    }

    static long build(long[] segTree, long[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return segTree[node] = arr[nodeLeft];
        }
        int mid = nodeLeft + nodeRight >> 1;
        long left = build(segTree, arr, node << 1, nodeLeft, mid);
        long right = build(segTree, arr, node << 1 | 1, mid + 1, nodeRight);
        return segTree[node] = merge(left, right);
    }

    static long merge(long leftVal, long rightVal) {
        return leftVal + rightVal;
    }

    static long mergeBlock(long val, int size) {
        return val * size;
    }

    static void pushDown(long val, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            segTree[node] += val;
            return;
        }
        lazyExist[node] = true;
        lazy[node] += val;
        segTree[node] += mergeBlock(val, nodeRight - nodeLeft + 1);
    }

    static long update(int node, int nodeLeft, int nodeRight, int left, int right, long val) {
        if (nodeLeft > right || nodeRight < left) {
            return segTree[node];
        }
        if (nodeLeft == nodeRight) {
            return segTree[node] += val;
        }

        if (left <= nodeLeft && nodeRight <= right) {
            lazyExist[node] = true;
            lazy[node] += val;
            return segTree[node] += mergeBlock(val, nodeRight - nodeLeft + 1);
        }
        int mid = nodeLeft + nodeRight >> 1;
        if (lazyExist[node]) {
            pushDown(lazy[node], node << 1, nodeLeft, mid);
            pushDown(lazy[node], node << 1 | 1, mid + 1, nodeRight);
            lazyExist[node] = false;
            lazy[node] = 0;
        }
        long leftVal = update(node << 1, nodeLeft, mid, left, right, val);
        long rightVal = update(node << 1 | 1, mid + 1, nodeRight, left, right, val);
        return segTree[node] = merge(leftVal, rightVal);
    }

    static long query(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (nodeRight < left || right < nodeLeft) {
            return 0;
        }

        if (left <= nodeLeft && nodeRight <= right) {
            return segTree[node];
        }
        int mid = nodeLeft + nodeRight >> 1;
        if (lazyExist[node]) {
            pushDown(lazy[node], node << 1, nodeLeft, mid);
            pushDown(lazy[node], node << 1 | 1, mid + 1, nodeRight);
            lazyExist[node] = false;
            lazy[node] = 0;
        }
        return merge(query(node << 1, nodeLeft, mid, left, right), query(node << 1 | 1, mid + 1, nodeRight, left, right));
    }


}
