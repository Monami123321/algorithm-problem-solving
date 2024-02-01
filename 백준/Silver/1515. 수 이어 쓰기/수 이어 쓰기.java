import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int num = 1;
        int pointer = 0;
        while (pointer < arr.length) {
            char[] tmp = Integer.toString(num).toCharArray();
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == arr[pointer]) {
                    pointer++;
                    if (pointer > arr.length-1) {
                        break;
                    }
                }
            }
            num++;
        }
        System.out.println(--num);


        br.close();
    }
}
