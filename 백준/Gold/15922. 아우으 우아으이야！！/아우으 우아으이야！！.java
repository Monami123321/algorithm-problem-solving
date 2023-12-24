import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nextStart = Integer.parseInt(st.nextToken());
            int nextEnd = Integer.parseInt(st.nextToken());
            if(nextStart <= end) {
                end = Math.max(end, nextEnd);
            } else {
                sum += end-start;
                start = nextStart;
                end = nextEnd;
            }
        }
        sum += end-start;
        System.out.println(sum);

        br.close();
    }
}
