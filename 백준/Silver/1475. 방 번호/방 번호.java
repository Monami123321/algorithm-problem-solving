import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] visited = new int[10];
        while (n > 0) {
            visited[(n % 10)]++;
            n /= 10;
        }
        int max = visited[6] + visited[9];
        if ((max & 1) != 0) {
            max++;
        }
        max = visited[6] = max >> 1;
        visited[9] = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, visited[i]);
        }
        System.out.println(max);
        br.close();
    }
}
