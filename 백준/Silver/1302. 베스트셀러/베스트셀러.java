import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            hm.merge(tmp, 1, (oldVal, newVal) -> oldVal + 1);
        }
        System.out.println(hm.entrySet().stream().sorted((a, b) -> {
            if (a.getValue().intValue() != b.getValue()) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        }).findFirst().get().getKey());


        br.close();
    }

}
