import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sqrt = (long)Math.sqrt(n);
        if(sqrt*sqrt<n) {
            ++sqrt;
        }
        System.out.println(sqrt);
        sc.close();
    }
    
}