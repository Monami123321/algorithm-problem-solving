import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[] parent;
    
    static int findSet(int x) {
        if(parent[x] != x) {
            return parent[x] = findSet(parent[x]);
        }
        return x;
        
    }
    
    static void union(int x, int y) {
        if(y>x) {
            parent[findSet(y)] = findSet(x);    
        } else if(y<x) {
            parent[findSet(x)] = findSet(y);
        } else {
            return;
        }
        
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String yes = "YES\n";
        String no = "NO\n";
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 0:
                    union(a,b);
                    break;

                case 1:
                    if(findSet(a) == findSet(b)) {
                        sb.append(yes);
                    } else {
                        sb.append(no);
                    }
                    break;
            }

        }

        System.out.print(sb);

        
    }
}
