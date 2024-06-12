import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            String[] arr = br.readLine().split(" ");

            sb.append(Arrays.stream(arr).map(e -> {
                return new StringBuilder(e).reverse();
            }).collect(Collectors.joining(" ", "", "\n")));
        }
        System.out.print(sb);
        br.close();
    }
}
