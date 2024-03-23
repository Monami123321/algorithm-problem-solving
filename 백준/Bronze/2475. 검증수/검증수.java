import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for(int i = 0; i < 5; ++i) {
            int now = Integer.parseInt(st.nextToken());
            ans += now * now;
        }
        System.out.println(ans % 10);
        br.close();
    }
}