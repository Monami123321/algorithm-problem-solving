import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())-1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = k;
        while (true) {
            sb.append(list.remove(index)).append(", ");
            if(list.isEmpty()) {
                break;
            }
            index += k;
            index %= list.size();
        }
        sb.replace(sb.length()-2,sb.length(),">");
        System.out.println(sb);
        br.close();
    }
}
