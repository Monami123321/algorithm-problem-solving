import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int len = arr.length;
        int[] cnt = new int[128];
        for (int i = 0; i < len; i++) {
            cnt[arr[i]]++;
        }
        int oddCnt = 0;
        for (int i = 65; i < 97; i++) {
            if ((cnt[i] & 1) != 0) {
                oddCnt++;
            }
        }
        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        int mid = len >> 1;

        outer:
        for (int i = 0; i < mid; i++) {
            for (int j = 65; j < 97; j++) {
                if (cnt[j] < 2) {
                    continue;
                }
                arr[i] = arr[len - 1 - i] = (char) j;
                cnt[j] -= 2;
                continue outer;
            }
        }
        for (int i = 65; i < 97; i++) {
            if (cnt[i] > 0) {
                arr[mid] = (char) i;
            }
        }
        System.out.print(arr);
        br.close();
    }
}
