import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        coungtingSort(arr);
        System.out.print(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
        br.close();
    }

    static void coungtingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        int[] cnt = new int[max + 1000001];

        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i] + 1000000]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] sorted = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[--cnt[arr[i] + 1000000]] = arr[i];
        }
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
}
