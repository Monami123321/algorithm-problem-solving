import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < b; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < a; i++) {
            if (!set.contains(arr[i])) {
                ans++;
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.println(ans);
        System.out.print(sb);

        br.close();
    }
}
