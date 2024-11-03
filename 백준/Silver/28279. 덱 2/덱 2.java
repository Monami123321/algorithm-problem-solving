import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3000000];
        int left = arr.length >> 1;
        int right = left + 1;
        int size = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "1":
                    arr[left--] = Integer.parseInt(st.nextToken());
                    size++;
                    break;
                case "2":
                    arr[right++] = Integer.parseInt(st.nextToken());
                    size++;
                    break;
                case "3":
                    if (size == 0) {
                        sb.append("-1\n");
                    } else {
                        size--;
                        sb.append(arr[++left]).append("\n");
                    }
                    break;
                case "4":
                    if (size == 0) {
                        sb.append("-1\n");
                    } else {
                        size--;
                        sb.append(arr[--right]).append("\n");
                    }
                    break;
                case "5":
                    sb.append(size).append("\n");
                    break;
                case "6":
                    if (size == 0) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "7":
                    if (size == 0) {
                        sb.append("-1\n");
                    } else {
                        sb.append(arr[left + 1]).append("\n");
                    }
                    break;
                case "8":
                    if (size == 0) {
                        sb.append("-1\n");
                    } else {
                        sb.append(arr[right - 1]).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
        br.close();
    }
}
