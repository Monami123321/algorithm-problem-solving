import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), "OX.", true);

            if (st.countTokens() == 1) {
                break;
            }
            int cntX = 0;
            int cntO = 0;
            int cntDot = 0;

            char[][] map = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                    if (map[i][j] == 'O') {
                        cntO++;
                    } else if (map[i][j] == 'X') {
                        cntX++;
                    } else {
                        cntDot++;
                    }
                }
            }
            if (Math.abs(cntX - cntO) > 1) {
                sb.append("invalid").append("\n");
                continue;
            }
            boolean flagX = false;
            boolean flagO = false;

            for (int i = 0; i < 3; i++) {
                int tmpX = 0;
                int tmpO = 0;
                for (int j = 0; j < 3; j++) {
                    if (map[i][j] == 'O') {
                        tmpO++;
                    } else if (map[i][j] == 'X') {
                        tmpX++;
                    }
                }
                if (tmpX == 3) {
                    flagX = true;
                }
                if (tmpO == 3) {
                    flagO = true;
                }
                tmpX = 0;
                tmpO = 0;
                for (int j = 0; j < 3; j++) {
                    if (map[j][i] == 'O') {
                        tmpO++;
                    } else if (map[j][i] == 'X') {
                        tmpX++;
                    }
                }
                if (tmpX == 3) {
                    flagX = true;
                }
                if (tmpO == 3) {
                    flagO = true;
                }
            }
            int tmpX = 0;
            int tmpO = 0;

            for (int i = 0; i < 3; i++) {
                if (map[i][i] == 'O') {
                    tmpO++;
                } else if (map[i][i] == 'X') {
                    tmpX++;
                }
            }
            if (tmpX == 3) {
                flagX = true;
            }
            if (tmpO == 3) {
                flagO = true;
            }
            for (int i = 0; i < 3; i++) {
                if (map[i][i] == 'O') {
                    tmpO++;
                } else if (map[i][i] == 'X') {
                    tmpX++;
                }
            }
            if (tmpX == 3) {
                flagX = true;
            }
            if (tmpO == 3) {
                flagO = true;
            }
            tmpX = 0;
            tmpO = 0;

            for (int i = 0; i < 3; i++) {
                if (map[i][2 - i] == 'O') {
                    tmpO++;
                } else if (map[i][2 - i] == 'X') {
                    tmpX++;
                }
            }
            if (tmpX == 3) {
                flagX = true;
            }
            if (tmpO == 3) {
                flagO = true;
            }

            if (flagX && flagO) {
                sb.append("invalid").append("\n");
                continue;
            }
            if (flagX && cntX - cntO != 1) {
                sb.append("invalid").append("\n");
                continue;
            }
            if (flagO && cntO - cntX != 0) {
                sb.append("invalid").append("\n");
                continue;
            }
            if (!flagX && !flagO && cntDot != 0) {
                sb.append("invalid").append("\n");
                continue;
            }
            if (!flagX && !flagO && cntX < cntO) {
                sb.append("invalid").append("\n");
                continue;
            }

            sb.append("valid").append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
