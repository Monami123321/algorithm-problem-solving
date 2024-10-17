import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static int[] arr;

    static {
        arr = new int[48];
        arr[1] = arr[2] = 1;
        for (int i = 3; i < 48; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int target = Integer.parseInt(br.readLine());
            int index = Arrays.binarySearch(arr, target);
            if (index < 0) {
                index = -index - 2;
            }
            List<Integer> list = new ArrayList<>();
            while (target != 0) {
                if (arr[index] > target) {
                    index--;
                    continue;
                }
                target -= arr[index];
                list.add(arr[index]);
            }
            sb.append(list.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
