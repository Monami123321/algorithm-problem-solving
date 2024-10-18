import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[4];
        int idx = System.in.read(buffer) - 1;
        int n = buffer[0] - 48;
        for (int i = 1; i < idx; i++) {
            n *= 10;
            n += buffer[i] - 48;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(n - 1 - i) + "*".repeat(2 * i + 1)).append("\n");
        }
        System.out.print(sb);
    }
}
