import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int lenA = getLen(n, k);
        if (lenA == -1) {
            System.out.println(-1);
            return;
        }
        int lenB = n - lenA;
        int index = n - 1 - (k - lenB * (lenA - 1));
        char[] arr = new char[n];
        for (int i = 0; i < lenA - 1; i++) {
            arr[i] = 'A';
        }
        for (int i = lenA - 1; i < n; i++) {
            arr[i] = 'B';
        }
        arr[index] = 'A';
        System.out.println(arr);
        br.close();
    }

    static int getLen(int n, int k) {
        int a = 1;
        int b = n - 1;
        while (a * b < k) {
            if (b == 0) {
                return -1;
            }
            a++;
            b--;
        }
        return a;
    }
}
