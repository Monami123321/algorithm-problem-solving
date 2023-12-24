import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        final long ref = 1_000_000_007;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int treeSize = 0;
        int treeStartIndex = 0;
        for (int i = 20; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                if (n == (1 << i)) {
                    treeSize = 1 << (i + 1);
                    treeStartIndex = 1 << i;
                    break;
                } else {
                    treeSize = 1 << (i + 2);
                    treeStartIndex = 1 << (i + 1);
                    break;
                }
            }
        }
        long[] segTree = new long[treeSize];
        for (int i = 1; i < segTree.length; i++) {
            segTree[i] = 1;
        } // 구간곱계산위해서 1로 초기화
        for (int i = 0; i < n; i++) {
            segTree[treeStartIndex + i] = Long.parseLong(br.readLine());
        } // 데이터 입력

        for (int i = segTree.length - 1; i >= 1; i--) {
            segTree[i] %= ref;
            segTree[i >> 1] *= segTree[i];
        } // 구간곱 끝

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int oldIndex = Integer.parseInt(st.nextToken()) - 1 + treeStartIndex;
                long newVal = Long.parseLong(st.nextToken());

                segTree[oldIndex] = newVal;

                while (oldIndex > 1) {
                    if ((oldIndex & 1) == 0) {
                        newVal = (segTree[oldIndex] * segTree[oldIndex + 1]) % ref;

                    } else {
                        newVal = (segTree[oldIndex] * segTree[oldIndex - 1]) % ref;
                    }
                    oldIndex >>= 1;
                    segTree[oldIndex] = newVal;
                }

            } else {
                int start = Integer.parseInt(st.nextToken()) - 1 + treeStartIndex;
                int end = Integer.parseInt(st.nextToken()) - 1 + treeStartIndex;

                long product = 1;

                while (end >= start) {
                    if ((start & 1) == 1) {
                        product *= segTree[start];
                        product %= ref;
                        start = (start + 1) >> 1;
                    } else {
                        start = (start + 1) >> 1;
                    }
                    if ((end & 1) == 0) {
                        product *= segTree[end];
                        product %= ref;
                        end = (end - 1) >> 1;
                    } else {
                        end = (end - 1) >> 1;
                    }
                }
                sb.append(product).append("\n");
            }

        }
        System.out.print(sb);

        br.close();
    }
}
