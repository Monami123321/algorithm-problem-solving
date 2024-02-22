import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i<n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr,(a,b) -> {
            int lenA = a.length();
            int lenB = b.length();
            if(lenA != lenB) {
                return lenA-lenB;
            }
            return a.compareTo(b);
        });
        Arrays.stream(arr).distinct().forEach(e -> {
            sb.append(e).append("\n");
        });
        System.out.print(sb);
        br.close();
    }
    
}