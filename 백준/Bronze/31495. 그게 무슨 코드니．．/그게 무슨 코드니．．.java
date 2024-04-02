import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        if (tmp.charAt(0) == '"' && tmp.charAt(tmp.length() - 1) == '"' && tmp.length() > 2) {
            System.out.println(tmp.substring(1,tmp.length()-1));
        } else {
            System.out.println("CE");
        }

        br.close();

    }
}
