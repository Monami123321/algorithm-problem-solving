import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        List<int[]> list = new ArrayList<>();
        int index = 1;
        int prev = arr[0][1];
        int start = arr[0][0];
        int cost = arr[0][2];
        while (index < n) {
            if (arr[index][0] <= prev) {
                cost = Math.min(cost, arr[index][2]);
                prev = Math.max(prev, arr[index][1]);
                index++;
            } else {
                list.add(new int[]{start, prev, cost});
                start = arr[index][0];
                prev = arr[index][1];
                cost = arr[index][2];
                index++;
            }
        }
        list.add(new int[]{start, prev, cost});
        System.out.println(list.size());
        System.out.println(list.stream().map(e -> e[0] + " " + e[1] + " " + e[2] + "\n").collect(Collectors.joining()));
        br.close();
    }

}

