import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            hm.put(arr[i], 0);
        }
        int index = 0;
        int ans = 1;
        int left = 0;
        while (index < n) {
            if (hm.get(arr[index]) == 0) {
                hm.put(arr[index++], 1);
            } else {
                if (hm.get(arr[index]) == k) {
                    ans = Math.max(ans, index - left);
                    while (arr[left] != arr[index]) {
                        hm.put(arr[left], hm.get(arr[left]) - 1);
                        left++;
                    }
                    if (left == index) {
                        hm.put(arr[left], hm.get(arr[left]) - 1);
                        left++;
                        index++;
                    } else {
                        left++;
                        index++;
                    }
                } else {
                    hm.put(arr[index], hm.get(arr[index]) + 1);
                    index++;
                }
            }
        }
        ans = Math.max(ans, index - left);
        System.out.println(ans);
        br.close();
    }
}
