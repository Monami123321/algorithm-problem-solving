import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int l = 0;
        int r = n - 1;
        int sum = Integer.MAX_VALUE;
        int lVal = 0;
        int rVal = 0;

        while (l < r) {
            int tmp = arr[l] + arr[r];
            if (sum > Math.abs(tmp)) {
                lVal = arr[l];
                rVal = arr[r];
                sum = Math.abs(tmp);
            }
            if(tmp >0) {
                r--;
            } else if(tmp<0) {
                l++;
            } else {
                break;
            }
        }

        System.out.printf("%d %d",lVal,rVal);


    }
}
