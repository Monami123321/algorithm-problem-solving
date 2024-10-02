import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        System.out.print(
                Arrays.stream(arr).sorted((a, b) -> {
                    int lenA = a.length;
                    int lenB = b.length;
                    if (lenB != lenA) {
                        return lenA - lenB;
                    }
                    int sumA = 0;
                    int sumB = 0;
                    for (int i = 0; i < lenA; i++) {
                        if ('1' <= a[i] && a[i] <= '9') {
                            sumA += a[i] - 48;
                        }
                    }
                    for (int i = 0; i < lenB; i++) {
                        if ('1' <= b[i] && b[i] <= '9') {
                            sumB += b[i] - 48;
                        }
                    }
                    if (sumA != sumB) {
                        return sumA - sumB;
                    }
                    return toStr(a).compareTo(toStr(b));
                }).map(e -> toStr(e)).collect(Collectors.joining("\n")));


        br.close();
    }

    static String toStr(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }


}
