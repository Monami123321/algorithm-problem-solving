import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Arrays.stream(br.readLine().split(" ")).anyMatch(e -> e.equals("9")) ? "F" : "S");
        br.close();
    }
}
