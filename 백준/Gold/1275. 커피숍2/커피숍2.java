import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        segTree = new long[n << 2];
        init(arr, 1, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            if (left > right) {
                left ^= right;
                right ^= left;
                left ^= right;
                
            }
            int index = Integer.parseInt(st.nextToken()) - 1;
            int val = Integer.parseInt(st.nextToken());

            sb.append(query(1, 0, n - 1, left, right)).append("\n");
            update(1, index, val, 0, n - 1);
        }
        System.out.print(sb);


        br.close();
    }

    static long init(int[] arr, int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return segTree[node] = arr[nodeLeft];
        }
        int mid = nodeLeft + nodeRight >> 1;
        long leftVal = init(arr, node << 1, nodeLeft, mid);
        long rightVal = init(arr, node << 1 | 1, mid + 1, nodeRight);
        return segTree[node] = leftVal + rightVal;
    }

    static long query(int node, int nodeLeft, int nodeRight, int left, int right) {
        if (nodeRight < left || nodeLeft > right) {
            return 0;
        }
        if (left <= nodeLeft && nodeRight <= right) {
            return segTree[node];
        }
        int mid = nodeLeft + nodeRight >> 1;
        long leftVal = query(node << 1, nodeLeft, mid, left, right);
        long rightVal = query(node << 1 | 1, mid + 1, nodeRight, left, right);
        return leftVal + rightVal;
    }

    static long update(int node, int index, int val, int nodeLeft, int nodeRight) {
        if (index < nodeLeft || index > nodeRight) {
            return segTree[node];
        }
        if (nodeLeft == nodeRight) {
            return segTree[node] = val;
        }
        int mid = nodeLeft + nodeRight >> 1;
        long leftVal = update(node << 1, index, val, nodeLeft, mid);
        long rightVal = update(node << 1 | 1, index, val, mid + 1, nodeRight);
        return segTree[node] = leftVal + rightVal;
    }

}

