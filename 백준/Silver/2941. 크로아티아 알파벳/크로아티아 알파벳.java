import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        char[] arr = new char[tmp.length() + 2];
        for (int i = 0; i < tmp.length(); i++) {
            arr[i + 2] = tmp.charAt(i);
        }
        int index = arr.length - 1;
        int cnt = 0;
        while (index >= 0) {
            cnt++;
            if (arr[index] == '-') {
                if (arr[index - 1] == 'c' || arr[index - 1] == 'd') {
                    index -= 2;
                } else {
                    index--;
                }
            } else if (arr[index] == '=') {
                if (arr[index - 1] == 's' || arr[index - 1] == 'c') {
                    index -= 2;
                } else if (arr[index - 1] == 'z') {
                    if (arr[index - 2] == 'd') {
                        index -= 3;
                    } else {
                        index -= 2;
                    }
                } else {
                    index--;
                }
            } else if (arr[index] == 'j') {
                if (arr[index - 1] == 'l' || arr[index - 1] == 'n') {
                    index -= 2;
                } else {
                    index--;
                }
            } else {
                index--;
            }
        }
        System.out.println(cnt - 2);
        br.close();
    }
}
