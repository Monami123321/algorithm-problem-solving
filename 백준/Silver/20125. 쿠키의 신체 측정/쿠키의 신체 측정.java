import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                if (tmp.charAt(j) == '_') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        int[] head = new int[2];
        head:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    head[0] = i;
                    head[1] = j;
                    break head;
                }
            }
        }
        int leftArm = 0;
        for (int i = 0; i < head[1]; i++) {
            if (map[head[0] + 1][i] == 1) {
                leftArm++;
            }

        }
        int rightArm = 0;
        for (int i = head[1] + 1; i < n; i++) {
            if (map[head[0] + 1][i] == 1) {
                rightArm++;
            }
        }
        int body = 0;
        int[] bodyPos = new int[2];
        for (int i = head[0] + 2; i < n; i++) {
            if (map[i][head[1]] == 1) {
                body++;
            } else {
                bodyPos[0] = i;
                bodyPos[1] = head[1];
                break;
            }

        }
        int leftLeg = 0;
        for (int i = bodyPos[0]; i < n; i++) {
            if (map[i][bodyPos[1] - 1] == 1) {
                leftLeg++;
            } else {
                break;
            }

        }
        int rightLeg = 0;
        for (int i = bodyPos[0]; i < n; i++) {
            if (map[i][bodyPos[1] + 1] == 1) {
                rightLeg++;
            } else {
                break;
            }
        }
        sb.append(head[0] + 2).append(" ").append(head[1] + 1).append("\n").append(leftArm).append(" ")
                .append(rightArm).append(" ").append(body).append(" ").append(leftLeg).append(" ")
                .append(rightLeg);
        System.out.print(sb);


        br.close();
    }
}
