import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = Long.toString(Long.parseLong(br.readLine()), 2).toCharArray();
        long ans = 0L;
        long ref = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - 1 - i] == 49) {
                ans += ref;
            }
            ref *= 3;
        }
        System.out.println(ans);
        br.close();
    }
}
