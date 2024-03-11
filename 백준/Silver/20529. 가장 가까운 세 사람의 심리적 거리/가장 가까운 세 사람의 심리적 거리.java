import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, String> numHm;
    static Map<String, Integer> strHm;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        int[] memo = new int[16];
        numHm = new HashMap<>();
        numHm.put(0, "ISTJ");
        numHm.put(1, "ISFJ");
        numHm.put(2, "INFJ");
        numHm.put(3, "INTJ");
        numHm.put(4, "ISTP");
        numHm.put(5, "ISFP");
        numHm.put(6, "INFP");
        numHm.put(7, "INTP");
        numHm.put(8, "ESTP");
        numHm.put(9, "ESFP");
        numHm.put(10, "ENFP");
        numHm.put(11, "ENTP");
        numHm.put(12, "ESTJ");
        numHm.put(13, "ESFJ");
        numHm.put(14, "ENFJ");
        numHm.put(15, "ENTJ");
        strHm = new HashMap<>();
        strHm.put("ISTJ", 0);
        strHm.put("ISFJ", 1);
        strHm.put("INFJ", 2);
        strHm.put("INTJ", 3);
        strHm.put("ISTP", 4);
        strHm.put("ISFP", 5);
        strHm.put("INFP", 6);
        strHm.put("INTP", 7);
        strHm.put("ESTP", 8);
        strHm.put("ESFP", 9);
        strHm.put("ENFP", 10);
        strHm.put("ENTP", 11);
        strHm.put("ESTJ", 12);
        strHm.put("ESFJ", 13);
        strHm.put("ENFJ", 14);
        strHm.put("ENTJ", 15);

        int[] arr = new int[3];
        for (int tc = 0; tc < testCases; tc++) {
            ans = Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                memo[strHm.get(st.nextToken())]++;
            }
            permutation(arr, memo, 0);
            sb.append(ans).append("\n");
            for (int i = 0; i < 16; i++) {
                memo[i] = 0;
            }
        }
        System.out.print(sb);

        br.close();

    }

    static void permutation(int[] arr, int[] memo, int depth) {

        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    sum += getDist(numHm.get(arr[i]), numHm.get(arr[j]));
                }
            }
            ans = Math.min(sum, ans);
            return;
        }
        for (int i = 0; i < 16; i++) {
            if (memo[i] == 0) {
                continue;
            }
            if (depth > 0 && arr[depth - 1] > i) {
                continue;
            }
            arr[depth] = i;
            memo[i]--;
            permutation(arr, memo, depth + 1);
            memo[i]++;
        }

    }

    static int getDist(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
