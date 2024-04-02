import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int maxWidth = 0;
        int maxHeight = 0;
        List<Integer> rList = new ArrayList<>();
        List<Integer> cList = new ArrayList<>();
        rList.add(0);
        cList.add(0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            if (dir == 0) {
                rList.add(index);
            } else {
                cList.add(index);
            }
        }
        rList.add(h);
        cList.add(w);
        Collections.sort(rList);
        Collections.sort(cList);
        int rLen = rList.size();
        int cLen = cList.size();

        for (int i = 1; i < rLen; i++) {
            maxHeight = Math.max(maxHeight, rList.get(i) - rList.get(i - 1));
        }
        for (int i = 1; i < cLen; i++) {
            maxWidth = Math.max(maxWidth, cList.get(i) - cList.get(i - 1));
        }
        System.out.println(maxHeight * maxWidth);
        br.close();
    }
}
