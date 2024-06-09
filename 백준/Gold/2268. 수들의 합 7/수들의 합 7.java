import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int startIndex = 1;
        while (startIndex < n) {
            startIndex <<= 1;
        }
        int treeSize = startIndex << 1;
        long[] segTree = new long[treeSize];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("0")) {
                int left = Integer.parseInt(st.nextToken()) + startIndex - 1;
                int right = Integer.parseInt(st.nextToken()) + startIndex - 1;
                if (left > right) {
                    int tmp = left;
                    left = right;
                    right = tmp;
                }
                sb.append(query(segTree, left, right)).append("\n");
            } else {
                int index = Integer.parseInt(st.nextToken()) + startIndex - 1;
                int val = Integer.parseInt(st.nextToken());
                update(segTree, index, val);
            }
        }
        System.out.print(sb);
        br.close();
    }

    static long query(long[] segTree, int left, int right) {
        long res = 0;
        while (right > left) {
            if ((left & 1) == 0) {
                left >>= 1;
            } else {
                res += segTree[left++];
                left >>= 1;
            }

            if ((right & 1) == 0) {
                res += segTree[right--];
                right >>= 1;
            } else {
                right >>= 1;
            }
        }
        if (left == right) {
            res += segTree[left];
        }
        return res;
    }

    static void update(long[] segTree, int index, int val) {
        long diff = val - segTree[index];
        while (index > 0) {
            segTree[index] += diff;
            index >>= 1;
        }
    }
}
