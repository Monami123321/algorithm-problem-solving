import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            if (input[i] < '0' || input[i] > '9') {
                sb.append(input[i]);
            }
        }
        String tmp = sb.toString();
        String target = br.readLine();
        if (tmp.contains(target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


        br.close();
    }
}
