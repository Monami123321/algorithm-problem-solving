import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int a = 0;
        int b = 1;
        while (true) {
            a = (a + b) % 1000000;
            a ^= b;
            b ^= a;
            a ^= b;
            if (a == 0 && b == 1) {
                break;
            }
            list.add(b);
        }
        int size = list.size() - 1;
        System.out.println(list.get((int) (n % size)));

        br.close();
    }
}
