import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int startIndex = 1;
        while (n > startIndex) {
            startIndex <<= 1;
        }
        int treeSize = startIndex << 1;
        long[] segTree = new long[treeSize];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int index = Integer.parseInt(st.nextToken()) - 1 + startIndex;
                long newVal = Long.parseLong(st.nextToken());
                update(segTree, index, newVal);
            } else {
                int left = Integer.parseInt(st.nextToken()) - 1 + startIndex;
                int right = Integer.parseInt(st.nextToken()) - 1 + startIndex;
                sb.append(getSum(segTree, left, right)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static void update(long[] segTree, int index, long newVal) {
        while (index > 1) {
            segTree[index] += newVal;
            index >>= 1;
        }
    }

    static long getSum(long[] segTree, int left, int right) {
        long res = 0;
        while (right > left) {
            if ((left & 1) == 0) {
                left >>= 1;
            } else {
                res += segTree[left++];
                left >>= 1;
            }

            if ((right & 1) != 0) {
                right >>= 1;
            } else {
                res += segTree[right--];
                right >>= 1;
            }
        }
        if (left == right) {
            res += segTree[left];
        }
        return res;
    }
}
