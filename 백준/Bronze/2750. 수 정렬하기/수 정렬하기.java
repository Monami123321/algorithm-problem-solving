import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt()+1000;
            max = Math.max(arr[i], max);
        }
        int[] count = new int[max+1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < max+1; i++) {
            count[i] += count[i - 1];
        }
        int[] sortedArr = new int[n];
        for (int i = n-1; i >= 0; i--) {
            sortedArr[--count[arr[i]]] = arr[i]-1000;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(sortedArr[i]);
        }
        sc.close();
    }
}
