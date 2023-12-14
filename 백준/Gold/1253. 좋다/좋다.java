import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        int cnt = 0;

        outer:
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (right > left) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                int sum = arr[left] + arr[right];
                if (sum == arr[i]) {
                    cnt++;
                    continue outer;
                } else if (sum > arr[i]) {
                    right--;
                } else {
                    left++;
                }


            }

        }
        System.out.println(cnt);


    }
}
