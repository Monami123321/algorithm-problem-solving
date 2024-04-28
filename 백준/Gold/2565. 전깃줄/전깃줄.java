import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        StringTokenizer st;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            max = Math.max(max, arr[i][1]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int startIndex = 1;
        while (startIndex < max) {
            startIndex <<= 1;
        }
        int treeSize = startIndex << 1;
        int[] segTree = new int[treeSize];
        for (int i = 0; i < n; i++) {
            int prev = query(segTree, startIndex, startIndex + arr[i][1] - 2);
            update(segTree, startIndex + arr[i][1] - 1, prev + 1);
        }
        System.out.println(n-segTree[1]);
        br.close();
    }

    static int query(int[] segTree, int left, int right) {
        int res = 0;
        while (right > left) {
            if ((left & 1) == 0) {
                left >>= 1;
            } else {
                res = Math.max(res, segTree[left++]);
                left >>= 1;
            }

            if ((right & 1) == 0) {
                res = Math.max(res, segTree[right--]);
                right >>= 1;
            } else {
                right >>= 1;
            }
        }
        if (right == left) {
            res = Math.max(res, segTree[left]);
        }
        return res;
    }

    static void update(int[] segTree, int index, int val) {
        while (index > 0) {
            segTree[index] = Math.max(segTree[index], val);
            index >>= 1;
        }
    }
}
