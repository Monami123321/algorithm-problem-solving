import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr, segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        build();
        System.out.print(cal(0, n - 1));
        br.close();
    }

    static int cal(int left, int right) {
        if (left > right) {
            return 0;
        }
        int index = query(1, 0, arr.length - 1, left, right);
        int val = arr[index] * (right - left + 1);
        int leftVal = cal(left, index - 1);
        int rightVal = cal(index + 1, right);
        return Math.max(Math.max(val, leftVal), rightVal);
    }

    static void build() {
        segTree = new int[arr.length << 2];
        build(1, 0, arr.length - 1);
    }

    static int build(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return segTree[node] = nodeLeft;
        }
        int mid = nodeLeft + nodeRight >> 1;
        int leftVal = build(node << 1, nodeLeft, mid);
        int rightVal = build(node << 1 | 1, mid + 1, nodeRight);
        return segTree[node] = merge(leftVal, rightVal);
    }

    static int merge(int left, int right) {
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return arr[left] > arr[right] ? right : left;
    }

    static int query(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (left > nodeRight || right < nodeLeft) {
            return -1;
        }
        if (left <= nodeLeft && nodeRight <= right) {
            return segTree[node];
        }
        int mid = nodeLeft + nodeRight >> 1;
        int leftVal = query(node << 1, nodeLeft, mid, left, right);
        int rightVal = query(node << 1 | 1, mid + 1, nodeRight, left, right);
        return merge(leftVal, rightVal);
    }

}
