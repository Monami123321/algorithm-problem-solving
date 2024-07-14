import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (n-- > 0) {
            String tmp = br.readLine();
            int index = tmp.indexOf("/");
            if (index == -1) {
                list1.add(tmp);
            } else {
                list2.add(Integer.parseInt(tmp.substring(index + 1)));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list1.stream().sorted((a, b) -> {
            int lenA = a.length();
            int lenB = b.length();
            if (lenA == lenB) {
                return a.compareTo(b);
            }
            return lenA - lenB;
        }).collect(Collectors.joining("\n")));
        if (sb.length() != 0) {
            sb.append("\n");
        }
        sb.append(list2.stream().sorted().map(e -> "boj.kr/" + e).collect(Collectors.joining("\n")));
        System.out.print(sb);
        br.close();
    }
}
