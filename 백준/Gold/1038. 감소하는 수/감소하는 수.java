import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) {
            dfs(0, i);
        }
        if (list.size() - 1 < n) {
            System.out.println(-1);
            return;
        }
        Collections.sort(list);
        System.out.println(list.get(n));
        br.close();
    }

    static void dfs(int depth, long val) {
        if (depth == 10) {
            return;
        }
        list.add(val);
        long digit = val % 10;
        for (int i = 0; i < 10; i++) {
            if (i >= digit) {
                continue;
            }
            dfs(depth + 1, val * 10 + i);
        }

    }

}
