import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] arr = new int[128];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            String str = br.readLine();
            int len = str.length();
            int cnt = len;
            for (int j = 0; j < len; j++) {
                arr[str.charAt(j)]++;
            }
            str = br.readLine();
            len = str.length();
            for (int j = 0; j < len; j++) {
                if (arr[str.charAt(j)] > 0) {
                    arr[str.charAt(j)]--;
                    cnt--;
                } else {
                    cnt++;
                }
            }
            sb.append("Case #").append(i).append(": ").append(cnt).append("\n");
            for (int j = 97; j < 123; j++) {
                arr[j] = 0;
            }
        }
        System.out.print(sb);
        br.close();
    }
}
