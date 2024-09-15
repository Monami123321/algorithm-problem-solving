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
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int[][] arr = new int[p][2];
            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[i][0] = x;
                arr[i][1] = y;
            }
            double[][] edges = getDist(arr);
            int cnt = 0;
            int target = p - s;
            Arrays.sort(edges, Comparator.comparingDouble(a -> a[2]));
            parent = new int[p];
            for (int i = 1; i < p; i++) {
                parent[i] = i;
            }
            int index = 0;
            double d = Double.MIN_VALUE;

            while (cnt < target) {
                if (union((int) edges[index][0], (int) edges[index][1])) {
                    d = Math.max(edges[index][2], d);
                    cnt++;
                }
                index++;
            }
            sb.append(String.format("%.2f\n", d));
        }
        System.out.print(sb);
        br.close();
    }

    static double[][] getDist(int[][] arr) {
        int resSize = arr.length * (arr.length - 1) >> 1;
        double[][] res = new double[resSize][3];
        int index = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                res[index][0] = i;
                res[index][1] = j;
                res[index++][2] = calDist(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
            }
        }
        return res;
    }

    static double calDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }

    static int findSet(int a) {
        if (parent[a] != a) {
            return parent[a] = findSet(parent[a]);
        }
        return a;
    }

    static boolean union(int a, int b) {
        int parentA = findSet(a);
        int parentB = findSet(b);

        if (parentA == parentB) {
            return false;
        }

        if (parentA < parentB) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
        return true;
    }


}
