import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        BitSet bitSet = new BitSet(1 << 25);
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (bitSet.get(now)) {
                continue;
            }
            sb.append(now).append(" ");
            bitSet.set(now);
        }
        System.out.print(sb);
        br.close();
    }
}
