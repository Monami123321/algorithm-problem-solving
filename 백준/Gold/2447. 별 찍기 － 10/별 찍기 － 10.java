import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int n = 0;
        int tmp = size;
        while (tmp > 1) {
            n++;
            tmp /= 3;
        }
        map = new char[size][size];
        recurr(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void recurr(int n) {
        if (n == 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = '*';
                }
            }
            map[1][1] = ' ';
            return;
        }
        recurr(n - 1);
        copy(n);
    }

    static void copy(int n) {
        int size = (int) Math.pow(3, n - 1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = i * size;
                int c = j * size;
                for (int k = 0; k < size; k++) {
                    for (int l = 0; l < size; l++) {
                        map[r + k][c + l] = map[k][l];
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[size + i][size + j] = ' ';
            }
        }
    }
}
