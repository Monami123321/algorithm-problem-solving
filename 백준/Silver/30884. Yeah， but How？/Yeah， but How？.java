import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int index = 1;
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        while(index < arr.length - 1) {
            char now = arr[index];
            if(now == '(') {
                sb.append(now);
                index++;
                continue;
            }
            if(arr[index - 1] == ')') {
                sb.append(now);
                if(arr[index + 1] == '(') {
                    sb.append('+');
                }
                index++;
                continue;
            }
            sb.append(1).append(now);
            if(arr[index + 1] == '(') {
                sb.append('+');
            }
            index++;
        }
        if(arr[index - 1] == '(') {
            sb.append(1);
        }
        sb.append(')');
        System.out.print(sb);
        br.close();
    }
}
