import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>(Arrays.asList("Fizz", "Buzz", "FizzBuzz"));
        int n = 0;
        for (int i = 0; i < 3; i++) {
            String tmp = br.readLine();
            if (!set.contains(tmp)) {
                n = Integer.parseInt(tmp) + 3 - i;
            }
        }
        String ans;
        if (n % 15 == 0) {
            ans = "FizzBuzz";
        } else if (n % 3 == 0) {
            ans = "Fizz";
        } else if (n % 5 == 0) {
            ans = "Buzz";
        } else {
            ans = String.valueOf(n);
        }
        System.out.println(ans);
        br.close();
    }
}