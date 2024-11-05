import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] tmp = new int[n];
        int[] lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp[i] = Integer.MAX_VALUE;
        }
        int lisIdx = 0;
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(tmp, arr[i]);
            if (index < 0) {
                index = -index - 1;
            }
            tmp[index] = arr[i];
            lis[i] = index;
            lisIdx = Math.max(lisIdx, index);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lisIdx + 1).append("\n");
        Deque<Integer> stack = new ArrayDeque<>(1 << 20);
        for (int i = n - 1; i >= 0; i--) {
            if (lis[i] == lisIdx) {
                stack.push(arr[i]);
                lisIdx--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
