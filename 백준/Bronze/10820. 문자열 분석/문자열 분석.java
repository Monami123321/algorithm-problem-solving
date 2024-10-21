import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[4];
        for (; ; ) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            char[] tmp = s.toCharArray();
            for (char c : tmp) {
                if (c < 48) {
                    arr[3]++;
                } else if (c < 65) {
                    arr[2]++;
                } else if (c < 97) {
                    arr[1]++;
                } else {
                    arr[0]++;
                }
            }
            for (int j = 0; j < 4; j++) {
                sb.append(arr[j]).append(" ");
                arr[j] = 0;
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
