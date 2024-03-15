import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        n <<= 1;
        int treeSize = 0;
        int startIndex = 0;
        for (int i = 19; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                if (n == (1 << i)) {
                    treeSize = 1 << i;
                    startIndex = treeSize >> 1;
                } else {
                    treeSize = 1 << (i + 1);
                    startIndex = treeSize >> 1;
                }
                break;
            }
        }
        int[] segTree = new int[treeSize];
        Arrays.fill(segTree, Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            segTree[startIndex + i] = arr[i];
        }

        for (int i = treeSize - 1; i > 1; i--) {
            segTree[i >> 1] = Math.min(segTree[i >> 1], segTree[i]);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1 + startIndex;
            int right = Integer.parseInt(st.nextToken()) - 1 + startIndex;
            int ans = Integer.MAX_VALUE;

            while (right > left) {
                if ((left & 1) == 0) {
                    left >>= 1;
                } else {
                    ans = Math.min(ans, segTree[left++]);
                    left >>= 1;
                }

                if ((right & 1) != 0) {
                    right >>= 1;
                } else {
                    ans = Math.min(ans, segTree[right--]);
                    right >>= 1;
                }
            }
            if (right == left) {
                ans = Math.min(ans, segTree[left]);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

