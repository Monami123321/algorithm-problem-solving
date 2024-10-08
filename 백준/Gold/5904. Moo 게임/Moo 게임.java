import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list.add(3L);
        int size = 1;

        while (true) {
            long prev = list.get(size - 1);
            if (n <= prev) {
                break;
            }
            list.add((prev << 1) + 3 + size++);
        }
        System.out.println(recurr(size - 1, n));
        sc.close();
    }

    static char recurr(int index, int n) {
        if (n <= 3) {
            if (n == 1) {
                return 'm';
            }
            return 'o';
        }
        long len = list.get(index);
        int mid = 3 + index;
        long firstBoundary = (len - mid) >> 1; // 끝포함
        long secondBoundary = firstBoundary + mid;
        if (n <= firstBoundary) {
            return recurr(index - 1, n);
        } else if (n <= secondBoundary) {
            if (n == firstBoundary + 1) {
                return 'm';
            }
            return 'o';
        } else {
            n -= (int) secondBoundary;
            return recurr(index - 1, n);
        }
    }
}
