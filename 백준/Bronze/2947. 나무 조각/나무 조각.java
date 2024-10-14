import java.io.IOException;

public class Main {
    static byte[] buffer = new byte[10];
    static int index = 0;

    public static void main(String[] args) throws IOException {
        System.in.read(buffer);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    print(sb, arr);
                }
            }
        }
        System.out.print(sb);
    }

    static int nextInt() {
        int res = buffer[index] - 48;
        index += 2;
        return res;
    }

    static void print(StringBuilder sb, int[] arr) {
        for (int i = 0; i < 5; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }
}
