import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringBuilder sb = new StringBuilder();
        double sum = 0;
        int[] visited = new int[8001];
        for (int i = 0; i < n; i++) {
            sum += arr[i] = Integer.parseInt(br.readLine());
            visited[arr[i] + 4000]++;
        }
        Arrays.sort(arr);
        sb.append(Math.round(sum / n)).append("\n");
        sb.append(arr[n - 1 >> 1]).append("\n");

        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            if (visited[i] > max) {
                list.clear();
                list.add(i - 4000);
                max = visited[i];
            } else if (visited[i] == max) {
                list.add(i - 4000);
            }
        }
        if (list.size() == 1) {
            sb.append(list.get(0)).append("\n");
        } else {
            sb.append(list.get(1)).append("\n");
        }
        sb.append(arr[n - 1] - arr[0]).append("\n");
        System.out.print(sb);
        br.close();
    }
}
