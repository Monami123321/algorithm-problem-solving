import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        char now = arr[0];
        int zero = 0;
        int one = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != now) {
                if (now == '0') {
                    zero++;
                } else {
                    one++;
                }
                now = arr[i];
            }
        }
        if (arr[arr.length - 1] == '0') {
            zero++;
        } else {
            one++;
        }
        System.out.println(Math.min(zero, one));
        br.close();


    }
}
