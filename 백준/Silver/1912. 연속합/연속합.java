import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int val = Integer.parseInt(st.nextToken());
        int globalMax = val;
        int localMax = val;
        for (int i = 1; i < n; i++) {
            val = Integer.parseInt(st.nextToken());
            localMax = Math.max(localMax + val, val);
            globalMax = Math.max(globalMax, localMax);
        }
        System.out.println(globalMax);
        br.close();
    }
}