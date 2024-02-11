import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Record {
        int id, score, last, num;
        int[] arr;

        public Record(int i, int k) {
            this.id = i;
            this.arr = new int[k];
            this.last = Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCases; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int myTeam = Integer.parseInt(st.nextToken());
            int logNum = Integer.parseInt(st.nextToken());
            Record[] records = new Record[n];
            for (int i = 0; i < n; i++) {
                records[i] = new Record(i + 1, k);
            }


            for (int i = 0; i < logNum; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()) - 1;
                int problem = Integer.parseInt(st.nextToken()) - 1;
                int score = Integer.parseInt(st.nextToken());
                if (records[id].arr[problem] < score) {
                    records[id].score += score - records[id].arr[problem];
                    records[id].arr[problem] = score;
                }
                records[id].last = i;
                records[id].num++;
            }
            Arrays.sort(records, (a, b) -> {
                if (a.score != b.score) {
                    return b.score - a.score;
                }
                if (a.num != b.num) {
                    return a.num - b.num;
                }
                return a.last - b.last;
            });
            for (int i = 0; i < n; i++) {
                if (records[i].id == myTeam) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);


        br.close();
    }
}
