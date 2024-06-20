import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long a = Long.parseLong(br.readLine().replace(" ", ""));
        long b = Long.parseLong(br.readLine().replace(" ", ""));
        System.out.println(Math.min(a, b));
        br.close();
    }
}
