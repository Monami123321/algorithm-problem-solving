import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[1000];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            cnt[a]++;
            sum += a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sum / 10).append("\n");
        int max = 0;
        int index = 0;
        for (int i = 1; i < cnt.length; i++) {
            if (max < cnt[i]) {
                index = i;
                max = cnt[i];
            }
        }
        sb.append(index);
        System.out.print(sb);
        br.close();
    }
}
