import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[128];
        outer:
        while (true) {
            Arrays.fill(visited, false);
            String input = br.readLine();
            if (input.equals("*")) {
                break;
            }
            input.chars().forEach(e -> visited[e] = true);
            for (int i = 97; i <= 122; i++) {
                if (!visited[i]) {
                    sb.append("N\n");
                    continue outer;
                }
            }
            sb.append("Y\n");
        }
        System.out.print(sb);
        br.close();
    }
}
