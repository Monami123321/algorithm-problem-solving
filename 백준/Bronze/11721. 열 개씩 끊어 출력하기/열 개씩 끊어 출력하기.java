import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < len) {
            for (int i = 0; index + i < len && i < 10; i++) {
                sb.append(word.charAt(index + i));
            }
            sb.append("\n");
            index += 10;
        }
        System.out.print(sb);

        br.close();
    }
}
