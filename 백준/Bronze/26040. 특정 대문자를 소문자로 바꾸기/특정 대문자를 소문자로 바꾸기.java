import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Character> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken().charAt(0));
        }
        int len = list.size();
        outer:
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < len; j++) {
                if (input[i] == list.get(j)) {
                    input[i] ^= 32;
                    continue outer;
                }
            }
        }
        System.out.println(input);
        br.close();
    }
}
