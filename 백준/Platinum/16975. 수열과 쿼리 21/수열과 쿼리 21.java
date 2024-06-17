import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] segTree;
    static long[] lazyVal;
    static boolean[] lazyExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        lazyExist = new boolean[n << 2];
        lazyVal = new long[n << 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        build(arr);
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                update(1, 0, n - 1, left, right, val);
            } else {
                int index = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(1, 0, n - 1, index, index)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static void build(int[] arr) {
        segTree = new long[arr.length << 2];
        build(arr, 1, 0, arr.length - 1);

    }

    static long build(int[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return segTree[node] = arr[nodeLeft];
        }
        int mid = nodeLeft + nodeRight >> 1;
        long leftVal = build(arr, node << 1, nodeLeft, mid);
        long rightVal = build(arr, node << 1 | 1, mid + 1, nodeRight);
        return segTree[node] = leftVal + rightVal;
    }

    static void pushDown(int node, int nodeLeft, int nodeRight, long val) {
        if (nodeLeft == nodeRight) {
            segTree[node] += val;
            return;
        }
        lazyExist[node] = true;
        lazyVal[node] += val;
        segTree[node] += val * (nodeRight - nodeLeft + 1);
    }

    static long update(int node, int nodeLeft, int nodeRight, int left, int right, int val) {
        if (left > nodeRight || right < nodeLeft) {
            return segTree[node];
        }
        if (left <= nodeLeft && nodeRight <= right) {
            lazyVal[node] += val;
            lazyExist[node] = true;
            return segTree[node] += val * (nodeRight - nodeLeft + 1);
        }
        int mid = nodeLeft + nodeRight >> 1;
        if (lazyExist[node]) {
            pushDown(node << 1, nodeLeft, mid, lazyVal[node]);
            pushDown(node << 1 | 1, mid + 1, nodeRight, lazyVal[node]);
            lazyExist[node] = false;
            lazyVal[node] = 0;
        }

        long leftVal = update(node << 1, nodeLeft, mid, left, right, val);
        long rightVal = update(node << 1 | 1, mid + 1, nodeRight, left, right, val);
        return segTree[node] = leftVal + rightVal;
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
            pushDown(node << 1, nodeLeft, mid, lazyVal[node]);
            pushDown(node << 1 | 1, mid + 1, nodeRight, lazyVal[node]);
            lazyExist[node] = false;
            lazyVal[node] = 0;
        }
        long leftVal = query(node << 1, nodeLeft, mid, left, right);
        long rightVal = query(node << 1 | 1, mid + 1, nodeRight, left, right);
        return leftVal + rightVal;
    }

}
