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
        int[][] arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Comparator<int[]> cmp = Comparator.comparingInt(a -> a[0]);
        Arrays.sort(arr, cmp);
        int q = Integer.parseInt(br.readLine());
        int[] ref = new int[2];
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            double tmp = Double.parseDouble(br.readLine());
            ref[0] = (int) Math.ceil(tmp);
            int nextIndex = Arrays.binarySearch(arr, ref, cmp);
            if (nextIndex < 0) {
                nextIndex = -nextIndex - 1;
            }
            ref[0] = (int) Math.floor(tmp);
            int prevIndex = Arrays.binarySearch(arr, ref, cmp);
            if (prevIndex < 0) {
                prevIndex = -prevIndex - 1;
            }
            if (prevIndex == nextIndex) {
                prevIndex--;
            }

            if (arr[nextIndex][1] > arr[prevIndex][1]) {
                sb.append("1\n");
            } else if (arr[nextIndex][1] < arr[prevIndex][1]) {
                sb.append("-1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

}
