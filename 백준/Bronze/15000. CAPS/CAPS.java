import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] ^= 32;
        }
        System.out.println(arr);
        br.close();
    }
}
