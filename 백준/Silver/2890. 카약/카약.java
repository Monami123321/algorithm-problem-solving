import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int[][] arr = new int[R][3];
        for (int i = 0; i < R; i++) {
            arr[i][0] = getNum(map[i]);
            arr[i][1] = getDist(map[i]);
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        int rank = arr[0][2] = 1;
        for (int i = 1; i < R; i++) {
            if (arr[i - 1][1] == arr[i][1]) {
                arr[i][2] = rank;
            } else {
                arr[i][2] = ++rank;
            }
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < 9; i++) {
            sb.append(arr[i][2]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static int getDist(char[] arr) {
        int index = arr.length - 1;
        int dist = 0;
        while (index > 0) {
            if ('0' > arr[index] || '9' < arr[index]) {
                index--;
                dist++;
            } else {
                break;
            }
        }
        if (dist == 0) {
            return Integer.MAX_VALUE;
        }
        return dist;
    }

    static int getNum(char[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != '.') {
                return arr[i] - '0';
            }
        }
        return 10;
    }
}
