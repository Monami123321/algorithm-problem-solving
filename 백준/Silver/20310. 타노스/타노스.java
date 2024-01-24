import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int zeroLen = 0;
        int oneLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                zeroLen++;
            } else {
                oneLen++;
            }
        }
        zeroLen /= 2;
        oneLen /= 2;

        StringBuilder sb = new StringBuilder();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < arr.length; i++) {
            if (zero < zeroLen && arr[i] == '0') {
                sb.append('0');
                zero++;
            }
            if (one < oneLen && arr[i] == '1') {
                one++;
            } else if (one == oneLen && arr[i] == '1') {
                sb.append('1');
            }
        }
        System.out.print(sb);
        br.close();
    }
}
