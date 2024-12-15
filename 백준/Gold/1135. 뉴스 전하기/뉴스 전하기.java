import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        adjList = new ArrayList[n];
        adjList[0] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            adjList[i] = new ArrayList<>();
            adjList[Integer.parseInt(st.nextToken())].add(i);
        }
        System.out.println(recurr(0));
        br.close();
    }

    static int recurr(int node) {
        if (adjList[node].isEmpty()) {
            return 0;
        }
        int size = adjList[node].size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = recurr(adjList[node].get(i));
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < size; i++) {
            res = Math.max(res, arr[size - 1 - i] + i + 1);
        }
        return res;
    }
}
