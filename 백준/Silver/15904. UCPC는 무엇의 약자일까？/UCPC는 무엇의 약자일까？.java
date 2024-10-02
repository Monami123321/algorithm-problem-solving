import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] target = {'U', 'C', 'P', 'C'};
        int index = 0;
        int idx = 0;
        while (idx < arr.length && index < 4) {
            if (arr[idx] == target[index]) {
                index++;
            }
            idx++;
        }
        if (index == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
        br.close();
    }
}
