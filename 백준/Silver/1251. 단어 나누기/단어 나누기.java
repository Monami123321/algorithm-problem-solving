import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int len = arr.length;
        List<String> list = new ArrayList<>();
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                list.add(getStr(arr, i, j));
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
        br.close();
    }

    static String getStr(char[] arr, int a, int b) {
        StringBuilder sb = new StringBuilder();
        for (int i = a-1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        for (int i = b-1; i >= a; i--) {
            sb.append(arr[i]);

        }
        for (int i = arr.length-1; i >= b; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }


}
