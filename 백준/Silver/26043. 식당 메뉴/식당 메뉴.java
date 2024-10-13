import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                queue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            } else {
                if (!queue.isEmpty()) {
                    int food = Integer.parseInt(st.nextToken());
                    int[] now = queue.poll();
                    if (now[1] == food) {
                        list1.add(now[0]);
                    } else {
                        list2.add(now[0]);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (list1.isEmpty()) {
            sb.append("None\n");
        } else {
            sb.append(list1.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
        }
        if (list2.isEmpty()) {
            sb.append("None\n");
        } else {
            sb.append(list2.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "))).append("\n");
        }
        if (queue.isEmpty()) {
            sb.append("None");
        } else {
            sb.append(queue.stream().sorted(Comparator.comparingInt(a -> a[0])).map(e -> String.valueOf(e[0])).collect(Collectors.joining(" ")));
        }
        System.out.print(sb);
        br.close();
    }
}
