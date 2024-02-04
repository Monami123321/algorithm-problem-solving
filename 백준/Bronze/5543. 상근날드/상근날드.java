import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int burger = 1 << 29;
    for(int i = 0; i < 3; i++) {
        burger = Math.min(burger,Integer.parseInt(br.readLine()));
    }
    int beverage = 1 << 29;
    for(int i  = 0;  i < 2; i++) {
        beverage = Math.min(beverage,Integer.parseInt(br.readLine()));
    }
    System.out.println(burger+beverage-50);
    }
    
}
