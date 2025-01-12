import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, Integer> hm = new HashMap<>();
    static char[][] arr;
    static int len;

    static {
        hm.put("####.##.##.####", 0);
        hm.put("###..#####..###", 2);
        hm.put("###..####..####", 3);
        hm.put("####..###..####", 5);
        hm.put("####..####.####", 6);
        hm.put("###..#..#..#..#", 7);
        hm.put("####.#####.####", 8);
        hm.put("####.####..####", 9);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        len = n / 5;
        arr = new char[5][];
        String input = br.readLine();
        for (int i = 0; i < 5; i++) {
            arr[i] = input.substring(len * i, len * (i + 1)).toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (arr[0][i] == '.') {
                continue;
            }
            if (i + 2 < len && arr[0][i + 2] == '#') {
                int val = getInt(i);
                sb.append(val);
                if (val == 1) {
                    i ++;
                } else {
                    i += 3;
                }
            } else {
                sb.append(1);
            }
        }
        System.out.print(sb);
        br.close();
    }

    static int getInt(int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(arr[i][index + j]);
            }
        }
        int val = hm.getOrDefault(sb.toString(), -1);
        if (val == -1) {
            if (arr[4][index] == '#') {
                val = 1;
            } else {
                val = 4;
            }
        }
        return val;
    }
}
