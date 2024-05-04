import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            res = 2;
            char[] tmp = br.readLine().toCharArray();
            dfs(tmp, 0, tmp.length - 1, false);
            sb.append(res).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    static void dfs(char[] word, int left, int right, boolean flag) {
        if (left  >= right) {
            if (flag) {
                res = 1;
                return;
            } else {
                res = 0;
                return;
            }
        }
        if (word[left] == word[right]) {
            dfs(word, left + 1, right - 1, flag);
        } else if (!flag) {
            dfs(word, left + 1, right, true);
            if (res == 2) {
                dfs(word, left, right - 1, true);
            }
        } else {
            res = 2;
        }
    }
}
