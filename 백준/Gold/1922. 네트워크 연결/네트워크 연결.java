import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        int[][] arr = new int[m][3];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[2]));
        int pick = 0;
        int index = 0;
        int ans = 0;
        while (pick < n - 1) {
            int[] now = arr[index++];
            if (union(now[0], now[1])) {
                ans += now[2];
                pick++;
            }
        }
        System.out.println(ans);
        br.close();
    }

    static boolean union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        if (parentA == parentB) {
            return false;
        }
        if (parentA > parentB) {
            parent[parentA] = parentB;
        } else {
            parent[parentB] = parentA;
        }
        return true;
    }

    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }
}
