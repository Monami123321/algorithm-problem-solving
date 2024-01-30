import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = a + b + c;
        if (sum >= 100) {
            System.out.println("OK");
        } else {
            int min = a > b ? b : a;
            min = min > c ? c : min;
            if (min == a) {
                System.out.println("Soongsil");
            } else if (min == b) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
        br.close();
    }
}
