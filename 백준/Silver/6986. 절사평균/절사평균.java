import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] = (int) (Double.parseDouble(br.readLine()) * 10);
        }
        Arrays.sort(arr);
        int cut = sum;
        for (int i = 0; i < k; i++) {
            cut -= arr[i] + arr[n - 1 - i];
        }
        sb.append(String.format("%.2f", (double) cut / 10 / (n - (k << 1)))).append("\n");
        int massaged = cut;
        massaged += (arr[k] + arr[n - 1 - k]) * k;
        sb.append(String.format("%.2f", (double) massaged / 10 / n));
        System.out.print(sb);
        br.close();
    }
}
