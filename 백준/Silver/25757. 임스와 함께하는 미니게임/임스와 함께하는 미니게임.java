import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        int n = sc.nextInt();
        char cmd = sc.next().charAt(0);
        int divisor = 0;
        if (cmd == 'Y') {
            divisor = 1;
        } else if (cmd == 'F') {
            divisor = 2;
        } else {
            divisor = 3;
        }
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }
        System.out.println(set.size() / divisor);
        sc.close();
    }
}
