import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int len = arr[0].length;
        StringBuilder sb = new StringBuilder();
        outer:for (int i = 0; i < len; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j - 1][i] != arr[j][i]) {
                    sb.append("?");
                    continue outer;
                }
            }
            sb.append(arr[0][i]);
        }
        System.out.print(sb);
        br.close();
    }
}
