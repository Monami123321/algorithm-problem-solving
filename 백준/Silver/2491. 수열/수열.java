import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 1;
        int index = 0;
        int prevIndex = 0;
        int prevVal = arr[0];
        while (index < n) {
            if (arr[index] >= prevVal) {
                prevVal = arr[index++];
            } else {
                ans = Math.max(ans, index - prevIndex);
                prevIndex = index;
                prevVal = arr[index++];
            }
        }
        ans = Math.max(index - prevIndex, ans);
        index = 0;
        prevIndex = 0;
        prevVal = arr[0];
        while (index < n) {
            if (arr[index] <= prevVal) {
                prevVal = arr[index++];
            } else {
                ans = Math.max(ans, index - prevIndex);
                prevIndex = index;
                prevVal = arr[index++];
            }
        }
        ans = Math.max(index - prevIndex, ans);
        System.out.println(ans);
        br.close();
    }
}
