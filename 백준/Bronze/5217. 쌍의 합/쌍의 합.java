import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append("Pairs for ").append(n).append(": ");
            boolean res = getPairs(n, sb);
            if (res) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static boolean getPairs(int n, StringBuilder sb) {
        int limit = n >> 1;
        if ((n & 1) != 0) {
            limit++;
        }
        boolean flag = false;
        for (int i = 1; i < limit; i++) {
            sb.append(i).append(" ").append(n - i).append(", ");
            flag = true;
        }
        return flag;
    }
}
