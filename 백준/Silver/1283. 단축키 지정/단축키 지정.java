import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[128];
        StringBuilder sb = new StringBuilder();
        outer:
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            if (!visited[arr[0]] && !visited[arr[0] ^ 32]) {
                visited[arr[0]] = visited[arr[0] ^ 32] = true;
                print(arr, 0, sb);
                continue;
            }
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == ' ') {
                    if (!visited[arr[j + 1]] && !visited[arr[j + 1] ^ 32]) {
                        visited[arr[j + 1]] = visited[arr[j + 1] ^ 32] = true;
                        print(arr, j + 1, sb);
                        continue outer;
                    }
                }
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == ' ') {
                    continue;
                }
                if (!visited[arr[j]] && !visited[arr[j] ^ 32]) {
                    visited[arr[j]] = visited[arr[j] ^ 32] = true;
                    print(arr, j, sb);
                    continue outer;
                }
            }
            for (char c : arr) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void print(char[] arr, int index, StringBuilder sb) {
        for (int i = 0; i < index; i++) {
            sb.append(arr[i]);
        }
        sb.append("[").append(arr[index++]).append("]");
        for (int i = index; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        sb.append("\n");
    }
}
