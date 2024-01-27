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
        System.out.println(exp(a, b, c));


        br.close();
    }

    static long exp(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }

        long half = exp(a, b / 2, c);
        if ((b & 1) == 0) {
            return ((half % c) * (half % c)) % c;

        } else {
            return (((half % c) * (half % c)) % c * (a % c)) % c;
        }


    }
}
