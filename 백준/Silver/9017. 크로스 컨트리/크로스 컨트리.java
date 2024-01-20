import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            int[] check = new int[201];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                check[arr[i]]++;
            }
            int tmp = 1;
            int[][] scores = new int[201][8]; //{1 2 3 4 5 6 지금 몇 번째? 이게몇팀?}
            for (int i = 0; i < 201; i++) {
                for (int j = 0; j < 6; j++) {
                    scores[i][j] = 1 << 22;
                }
            }
            for (int i = 0; i < n; i++) {
                if (check[arr[i]] != 6) {
                    continue;
                }
                scores[arr[i]][scores[arr[i]][6]++] = tmp++;
                scores[arr[i]][7] = arr[i];
            }
            Arrays.sort(scores, (a, b) -> {
                int sumA = 0;
                int sumB = 0;
                for (int i = 0; i < 4; i++) {
                    sumA += a[i];
                    sumB += b[i];
                }
                if (sumA == sumB) {
                    return a[4] - b[4];
                }
                return sumA - sumB;
            });
            sb.append(scores[0][7]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
