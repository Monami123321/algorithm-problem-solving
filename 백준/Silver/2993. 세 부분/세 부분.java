import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                StringBuilder sb = new StringBuilder();
                list.add(sb.append(getReversedStr(input.substring(0, i)))
                        .append(getReversedStr(input.substring(i, j)))
                        .append(getReversedStr(input.substring(j))).toString());
            }
        }
        Collections.sort(list);
        System.out.print(list.get(0));
        br.close();
    }

    static String getReversedStr(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        boolean flag = (len & 1) != 0;
        int l = len >> 1;
        for (int i = 0; i < l; i++) {
            sb.append(s.charAt(len - 1 - i));
        }
        if (flag) {
            sb.append(s.charAt(l));
        }
        for (int i = l - 1; i >= 0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
