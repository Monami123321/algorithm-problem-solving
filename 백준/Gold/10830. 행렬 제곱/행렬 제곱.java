import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] res = pow(arr, b);
        if (b == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] %= 1000;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }
        if (exp == 2) {
            return matrixProduct(matrix);
        }

        int[][] half = pow(matrix,exp/2);

        if ((exp & 1) == 0) {
            return matrixProduct(half);
        } else {
            return sumProduct(matrixProduct(half), matrix);
        }
    }

    static int[][] matrixProduct(int[][] arr) {
        int len = arr.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += (arr[i][k] * arr[k][j]) % 1000;
                }
                res[i][j] = sum % 1000;
            }

        }
        return res;

    }
    static int[][] sumProduct(int[][] arr1, int[][] arr2) {
        int len = arr1.length;
        int[][] res = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += (arr1[i][k] * arr2[k][j]) % 1000;
                }
                res[i][j] = sum % 1000;
            }
        }
        return res;
    }


}
