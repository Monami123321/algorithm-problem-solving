import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int index = input.indexOf("JOI");
        while (index != -1) {
            cnt++;
            index = input.indexOf("JOI", index + 1);
        }
        sb.append(cnt).append("\n");
        index = input.indexOf("IOI");
        cnt = 0;
        while (index != -1) {
            cnt++;
            index = input.indexOf("IOI", index + 1);
        }
        sb.append(cnt);
        System.out.print(sb);

        br.close();
    }
}
