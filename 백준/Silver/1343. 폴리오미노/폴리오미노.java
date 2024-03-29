import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int len = arr.length;
        int now = 0;
        int prev = 0;
        while (now < len && arr[now] != '.') {
            now++;
        }
        while (now <= len) {
            if (now == len || arr[now] == '.') {
                if ((now - prev & 1) != 0) {
                    System.out.println(-1);
                    return;
                }
                if (now == prev) {
                    now++;
                    prev = now;
                } else if ((now - prev) % 4 == 0) {
                    while (prev < now) {
                        arr[prev++] = 'A';
                    }
                    now++;
                    prev++;
                } else {
                    while (prev < now - 2) {
                        arr[prev++] = 'A';
                    }
                    while (prev < now) {
                        arr[prev++] = 'B';
                    }
                    now++;
                    prev++;
                }
            } else {
                now++;
            }
        }
        System.out.println(arr);


        br.close();
    }
}
