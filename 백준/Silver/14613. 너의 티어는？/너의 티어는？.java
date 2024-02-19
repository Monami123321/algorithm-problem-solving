import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        double winRate = Double.parseDouble(st.nextToken());
        double loseRate = Double.parseDouble(st.nextToken());
        double drawRate = Double.parseDouble(st.nextToken());
        long[] factorial = new long[21];
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i < 21; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        double[] arr = new double[5];


        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i + j + k == 20) {
                        int score = 2000 + i * 50 - j * 50;
                        double rate = Math.pow(winRate, i) * Math.pow(loseRate, j) * Math.pow(drawRate, k)
                                * factorial[20] / factorial[i] / factorial[j] / factorial[k];

                        if (1000 <= score && score < 1500) {
                            arr[0] += rate;
                        } else if (1500 <= score && score < 2000) {
                            arr[1] += rate;
                        } else if (2000 <= score && score < 2500) {
                            arr[2] += rate;
                        } else if (2500 <= score && score < 3000) {
                            arr[3] += rate;
                        } else {
                            arr[4] += rate;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            sb.append(String.format("%.8f\n", arr[i]));
        }
        System.out.print(sb);
        br.close();
    }
}
