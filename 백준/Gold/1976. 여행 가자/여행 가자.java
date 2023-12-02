import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    static int findSet(int x) {
        if (parent[x] != x) {
            return parent[x] = findSet(parent[x]);
        }
        return x;


    }

    static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }


        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] target = new int[m];
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        int check = findSet(target[0]);
        for (int i = 1; i < m; i++) {
            if (findSet(target[i]) != check) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");

    }
}