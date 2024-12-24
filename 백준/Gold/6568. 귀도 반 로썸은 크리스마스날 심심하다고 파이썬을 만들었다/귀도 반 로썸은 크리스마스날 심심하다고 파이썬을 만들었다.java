import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] memory = new int[32];
        StringBuilder sb = new StringBuilder();
        int cmdRef = 7 << 5;
        int addrRef = 31;

        while (true) {
            String tmp = br.readLine();
            if (tmp == null) {
                break;
            }
            memory[0] = Integer.parseInt(tmp, 2);
            for (int i = 1; i < 32; i++) {
                memory[i] = Integer.parseInt(br.readLine(), 2);
            }
            byte acc = 0;
            int pc = 0;
            while (true) {
                int cmd = (memory[pc] & cmdRef) >> 5;
                int addr = memory[pc++] & addrRef;
                pc %= 32;
                if (cmd == 0) {
                    memory[addr] = acc;
                } else if (cmd == 1) {
                    acc = (byte) memory[addr];
                } else if (cmd == 2) {
                    if (acc == 0) {
                        pc = addr;
                    }
                } else if (cmd == 3) {

                } else if (cmd == 4) {
                    acc--;
                } else if (cmd == 5) {
                    acc++;
                } else if (cmd == 6) {
                    pc = addr;
                } else {
                    break;
                }
            }
            sb.append(String.format("%8s\n", Integer.toBinaryString(acc & 255)).replace(' ', '0'));
        }
        System.out.print(sb);
        br.close();
    }
}