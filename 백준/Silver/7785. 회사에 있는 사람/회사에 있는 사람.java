import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            if (arr[1].equals("enter")) {
                treeSet.add(arr[0]);
            } else {
                treeSet.remove(arr[0]);
            }
        }
        System.out.print(String.join("\n", treeSet));
        br.close();
    }
}
