import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int diagonal = Integer.parseInt(st.nextToken());
        diagonal *= diagonal;
        int h = Integer.parseInt(st.nextToken());
        h *= h;
        int w = Integer.parseInt(st.nextToken());
        w *= w;
        System.out.printf("%d ", (int) Math.sqrt((long) diagonal * h / (h + w)));
        System.out.print((int) Math.sqrt((long) diagonal * w / (h + w)));
        br.close();
    }
}
