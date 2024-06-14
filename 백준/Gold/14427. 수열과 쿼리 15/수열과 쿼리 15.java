import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] segTree = build(arr);
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int index = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                update(segTree, arr, 1, 0, n - 1, index - 1, val);
            } else {
                sb.append(query(segTree, arr, 1, 0, n - 1, 0, n - 1)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static int[] build(int[] arr) {
        int[] segTree = new int[arr.length << 2];
        build(segTree, arr, 1, 0, arr.length - 1);
        return segTree;
    }

    static int build(int[] segTree, int[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return segTree[node] = nodeLeft + 1;
        }

        int mid = nodeLeft + ((nodeRight - nodeLeft) >> 1);
        int left = build(segTree, arr, node << 1, nodeLeft, mid);
        int right = build(segTree, arr, node << 1 | 1, mid + 1, nodeRight);
        return segTree[node] = merge(arr, left, right);
    }

    static int merge(int[] arr, int leftVal, int rightVal) {
        if (leftVal == 0) {
            return rightVal;
        }
        if (rightVal == 0) {
            return leftVal;
        }
        if (arr[rightVal - 1] == arr[leftVal - 1]) {
            return Math.min(rightVal, leftVal);
        }
        return arr[rightVal - 1] > arr[leftVal - 1] ? leftVal : rightVal;
    }

    static int update(int[] segTree, int[] arr, int node, int nodeLeft, int nodeRight, int index, int val) {
        if (nodeLeft == nodeRight && nodeLeft == index) {
            arr[index] = val;
            return index + 1;
        }
        if (index < nodeLeft || nodeRight < index) {
            return segTree[node];
        }

        int mid = nodeLeft + ((nodeRight - nodeLeft) >> 1);
        int leftVal = update(segTree, arr, node << 1, nodeLeft, mid, index, val);
        int rightVal = update(segTree, arr, node << 1 | 1, mid + 1, nodeRight, index, val);
        return segTree[node] = merge(arr, leftVal, rightVal);
    }

    static int query(int[] segTree, int[] arr, int node, int nodeLeft, int nodeRight, int left, int right) {
        if (right < nodeLeft || left > nodeRight) {
            return 0;
        }

        if (left <= nodeLeft && nodeRight <= right) {
            return segTree[node];
        }

        int mid = nodeLeft + ((nodeRight - nodeLeft) >> 1);
        int leftVal = query(segTree, arr, node << 1, nodeLeft, mid, left, right);
        int rightVal = query(segTree, arr, node << 1 | 1, mid + 1, nodeRight, left, right);
        return merge(arr, leftVal, rightVal);
    }

}
