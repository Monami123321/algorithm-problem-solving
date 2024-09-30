import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr1 = br.readLine().toCharArray(); // 기본
        char[] arr2 = new char[n]; // 클릭
        System.arraycopy(arr1, 0, arr2, 0, n);
        click(arr2, 0);
        char[] goal = br.readLine().toCharArray();
        int cnt1 = 0;
        int cnt2 = 1;
        for (int i = 1; i < n; i++) {
            if (arr1[i - 1] != goal[i - 1]) {
                click(arr1, i);
                cnt1++;
            }
            if (arr2[i - 1] != goal[i - 1]) {
                click(arr2, i);
                cnt2++;
            }
        }
        if (arr1[n - 1] != goal[n - 1] && arr2[n - 1] != goal[n - 1]) {
            System.out.println(-1);
        } else if (arr1[n - 1] == goal[n - 1] && arr2[n - 1] != goal[n - 1]) {
            System.out.println(cnt1);
        } else if (arr2[n - 1] == goal[n - 1] && arr1[n - 1] != goal[n - 1]) {
            System.out.println(cnt2);
        } else {
            System.out.println(Math.min(cnt1, cnt2));
        }


        br.close();
    }

    static void click(char[] arr, int index) {
        if (index == 0) {
            arr[0] ^= 1;
            arr[1] ^= 1;
        } else if (index == arr.length - 1) {
            arr[index] ^= 1;
            arr[index - 1] ^= 1;
        } else {
            arr[index] ^= 1;
            arr[index - 1] ^= 1;
            arr[index + 1] ^= 1;
        }
    }
}
