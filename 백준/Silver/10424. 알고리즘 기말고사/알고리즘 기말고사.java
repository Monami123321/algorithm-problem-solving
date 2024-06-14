import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int prev = Integer.parseInt(st.nextToken());
//            (n-1-i) - (n-prev)
            arr[prev - 1] = prev - 1 - i;
        }
        System.out.print(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
        br.close();
    }
}
