import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[n][3]; //{인덱스,값,점수}
        Map<Integer, int[]> hm = new HashMap<>();
        boolean[] visited = new boolean[1_000_001];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
            visited[arr[i][1]] = true;
            max = Math.max(max, arr[i][1]);
            hm.put(arr[i][1], arr[i]);
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            int index = arr[i][1];
            while (index <= max) {
                if (visited[index]) {
                    arr[i][2]++;
                    hm.get(index)[2]--;
                }
                index += arr[i][1];
            }
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][2]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
