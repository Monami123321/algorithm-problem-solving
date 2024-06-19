import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            build();
            sb.append(cal(0, n - 1)).append("\n");
        }
        System.out.print(sb);


        br.close();
    }

    static long cal(int left, int right) {
        if (left > right) {
            return 0;
        }
        int index = query(1, 0, arr.length - 1, left, right);
        long val = (long) arr[index] * (right - left + 1);
        long leftVal = cal(left, index - 1);
        long rightVal = cal(index + 1, right);

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

    static int query(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (nodeRight < left || right < nodeLeft) {
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

    static int merge(int left, int right) {
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return arr[left] > arr[right] ? right : left;
    }
}
