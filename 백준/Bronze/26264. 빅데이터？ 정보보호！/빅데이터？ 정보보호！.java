import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int len = s.length();
        int index = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        while (index < len) {
            index = s.indexOf("security", index);
            if (index != -1) {
                cnt1++;
                index += 8;
            }
            if (index == -1) {
                break;
            }
        }
        index = 0;
        while (index < len) {
            index = s.indexOf("bigdata", index);
            if (index != -1) {
                cnt2++;
                index += 7;
            }
            if (index == -1) {
                break;
            }
        }
        System.out.println(cnt1 > cnt2 ? "security!" : cnt1 == cnt2 ? "bigdata? security!" : "bigdata?");
        br.close();
    }
}
