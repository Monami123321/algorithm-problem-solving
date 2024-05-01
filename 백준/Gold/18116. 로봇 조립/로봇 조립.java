import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 1_000_000;
    static int[] parent = new int[SIZE + 1];
    static int[] size = new int[SIZE + 1];

    static {
        for (int i = 1; i <= SIZE; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if (cmd == 'I') {
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                sb.append(size[findSet(Integer.parseInt(st.nextToken()))]).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    static void union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);
        if (parentA == parentB) {
            return;
        }
        if (parentA > parentB) {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        } else {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }
    }

    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }
}
