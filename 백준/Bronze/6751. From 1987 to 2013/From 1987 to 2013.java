import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[6];
        System.in.read(buffer);
        int index = 0;
        int n = buffer[index++] - 48;
        while (Character.isDigit(buffer[index])) {
            n *= 10;
            n += buffer[index++] - 48;
        }
        boolean[] visited = new boolean[10];
        n++;
        outer:
        while (true) {
            int t = n;
            Arrays.fill(visited, false);
            while (t > 0) {
                if (visited[t % 10]) {
                    n++;
                    continue outer;
                }
                visited[t % 10] = true;
                t /= 10;
            }
            System.out.println(n);
            return;
        }
    }
}
