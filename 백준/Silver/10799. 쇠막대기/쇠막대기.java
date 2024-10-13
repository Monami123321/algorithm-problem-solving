import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().replace("()", "x").toCharArray();
        int cnt = 0;
        int index = 0;
        int staff = 0;
        while (index < arr.length) {
            if (arr[index] == 'x') {
                cnt += staff;
            } else if (arr[index] == '(') {
                staff++;
            } else {
                cnt++;
                staff--;
            }
            index++;
        }
        System.out.println(cnt);
        br.close();
    }
}
