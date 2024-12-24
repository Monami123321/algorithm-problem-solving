import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int lenA = a.length();
        int lenB = b.length();
        int len = getGCD(lenA, lenB);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= len; i++) {
            if (len % i == 0) {
                list.add(i);
                if (i * i != len) {
                    list.add(len / i);
                }
            }
        }
        Collections.sort(list);
        Set<String> set = new HashSet<>();
        for (int i : list) {
            for (int j = 0; j <= lenB - i; j++) {
                String substr = b.substring(j, j + i);
                if (set.contains(substr)) {
                    continue;
                }
                if (isValid(b, substr)) {
                    set.add(substr);
                    if (isValid(a, substr)) {
                        System.out.println(substr);
                        return;
                    }
                }
            }
        }
        System.out.println("No solution");
        br.close();
    }

    static int getGCD(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    static boolean isValid(String target, String s) {
        StringBuilder sb = new StringBuilder();
        int t = target.length() / s.length();
        for (int i = 0; i < t; i++) {
            sb.append(s);
        }
        return target.contentEquals(sb);
    }
}
