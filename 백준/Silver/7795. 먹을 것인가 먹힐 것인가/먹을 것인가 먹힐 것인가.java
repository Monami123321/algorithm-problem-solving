import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int now = arr1[i];
                int index = Arrays.binarySearch(arr2, now);
                if (index < 0) {
                    index = -index - 1;
                } else {
                    while (index > 0 && arr2[index] == arr2[index - 1]) {
                        index--;
                    }
                }
                cnt += index;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
