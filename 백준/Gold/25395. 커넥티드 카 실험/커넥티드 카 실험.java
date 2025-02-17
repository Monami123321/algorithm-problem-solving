import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken())-1;
        int[][] arr = new int[n][3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int left = s - 1;
        int right = s + 1;
        int limitL = arr[s][0] - arr[s][1];
        int limitR = arr[s][0] + arr[s][1];
        while (left >= 0 || right < n) {
            boolean flagR = true;
            boolean flagL = true;
            if (left >= 0) {
                if (arr[left][0] >= limitL) {
                    limitL = Math.min(limitL, arr[left][0] - arr[left][1]);
                    limitR = Math.max(limitR, arr[left][0] + arr[left][1]);
                    left--;
                    flagL = false;
                }
            }
            if (right < n) {
                if (arr[right][0] <= limitR) {
                    limitR = Math.max(limitR, arr[right][0] + arr[right][1]);
                    limitL = Math.min(limitL, arr[right][0] - arr[right][1]);
                    flagR = false;
                    right++;
                }
            }
            if (flagR && flagL) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = left+2; i < right+1; i++) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}

