import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][128];
        char[][] input = new char[n][];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[j][input[i][j]]++;
            }
        }
        char[] ans = new char[m];
        for (int i = 0; i < m; i++) {
            int index = 0;
            int max = 0;
            for (int j = 65; j < 92; j++) {
                if (max < arr[i][j]) {
                    index = j;
                    max = arr[i][j];
                }
            }
            ans[i] = (char) index;
        }
        int dist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans[j] != input[i][j]) {
                    dist++;
                }
            }
        }
        System.out.println(ans);
        System.out.println(dist);
        br.close();
    }

}