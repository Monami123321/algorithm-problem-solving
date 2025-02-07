import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        int n = 0;
        int tmp = 0;
        while (true) {
            tmp = System.in.read();
            if (tmp < 48) {
                break;
            }
            n *= 10;
            n += tmp - 48;
        }
        char from = 65;
        char via = 66;
        char to = 67;
        while (n > 2) {
            n -= 2;
            recur(n, from, via, to);
            sb.append(from).append(" ").append(via).append("\n");
            sb.append(from).append(" D\n");
            sb.append(via).append(" D\n");
            ans += 3;
            to ^= from;
            from ^= to;
            to ^= from;
        }

        if (n == 1) {
            sb.append(from).append(" D");
            ans++;
        } else {
            sb.append(from).append(" ").append(via).append("\n");
            sb.append(from).append(" D\n");
            sb.append(via).append(" D");
            ans += 3;
        }
        System.out.println(ans);
        System.out.print(sb);
    }

    static void recur(int n, char from, char via, char to) {
        if (n == 1) {
            ans++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        recur(n - 1, from, to, via);
        sb.append(from).append(" ").append(to).append("\n");
        recur(n - 1, via, from, to);
        ans++;
    }
}
