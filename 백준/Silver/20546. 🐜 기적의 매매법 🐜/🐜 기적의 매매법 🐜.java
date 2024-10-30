import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[14];
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int money = m;
        int cnt = 0;
        int index = 0;
        while (index < 14) {
            if (money >= arr[index]) {
                cnt += money / arr[index];
                money %= arr[index];
            }
            index++;
        }
        cnt = cnt * arr[13] + money;


        index = 2;
        money = m;
        int s = 0;
        while (++index < 14) {
            if (arr[index - 3] > arr[index - 2] && arr[index - 2] > arr[index - 1]) {
                s += money / arr[index];
                money %= arr[index];
            } else if (arr[index - 3] < arr[index - 2] && arr[index - 2] < arr[index - 1]) {
                money += s * arr[index];
                s = 0;
            }
        }
        System.out.println(cnt == money ? "SAMESAME" : cnt > money ? "BNP" : "TIMING");
        br.close();
    }
}
