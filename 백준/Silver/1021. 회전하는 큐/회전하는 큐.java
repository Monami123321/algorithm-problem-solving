import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int pt = 1;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = arr[i];
            int left = target <= pt ? pt - target : n - target + pt;
            int right = target > pt ? target - pt : n - pt + target;
            cnt += Math.min(left, right);
            pt = target;
            n--;
            for (int j = i + 1; j < m; j++) {
                if (arr[j] > target) {
                    arr[j]--;
                }
            }
        }
        System.out.println(cnt);


        br.close();
    }
}
