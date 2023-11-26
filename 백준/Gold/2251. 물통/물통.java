import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static class Glass {
        int capa, now;

        public Glass() {
        }

        public Glass(int capa, int now) {
            this.capa = capa;
            this.now = now;
        }

        public Glass(int capa) {
            this.capa = capa;
        }
    }

    static boolean[][][] visited;
    static HashSet<Integer> ans;

    static void dfs(Glass a, Glass b, Glass c) {
        if (visited[a.now][b.now][c.now]) {
            return;
        }
        visited[a.now][b.now][c.now] = true;
        if (a.now == 0) {
            ans.add(c.now);
        }

        // a->b로 부었을 때
        if (a.now <= b.capa - b.now) {
            int tmp = a.now;
            b.now += tmp;
            a.now = 0;
            dfs(a, b, c);
            a.now = tmp;
            b.now -= tmp;
        } else {
            int tmp = b.now;
            b.now = b.capa;
            a.now -= b.capa - tmp;
            dfs(a, b, c);
            a.now += b.capa - tmp;
            b.now = tmp;
        }
        // a-> c로 부었을 때
        if (a.now <= c.capa - c.now) {
            int tmp = a.now;
            c.now += tmp;
            a.now = 0;
            dfs(a, b, c);
            a.now = tmp;
            c.now -= tmp;
        } else {
            int tmp = b.now;
            b.now = b.capa;
            c.now -= b.capa - tmp;
            dfs(a, b, c);
            c.now += b.capa - tmp;
            b.now = tmp;
        }
        //b ->a
        if (b.now <= a.capa - a.now) {
            int tmp = b.now;
            a.now += tmp;
            b.now = 0;
            dfs(a, b, c);
            b.now = tmp;
            a.now -= tmp;
        } else {
            int tmp = a.now;
            a.now = a.capa;
            b.now -= a.capa - tmp;
            dfs(a, b, c);
            b.now += a.capa - tmp;
            a.now = tmp;
        }
        // b ->c
        if (b.now <= c.capa - c.now) {
            int tmp = b.now;
            c.now += tmp;
            b.now = 0;
            dfs(a, b, c);
            b.now = tmp;
            c.now -= tmp;
        } else {
            int tmp = c.now;
            c.now = c.capa;
            b.now -= c.capa - tmp;
            dfs(a, b, c);
            b.now += c.capa - tmp;
            c.now = tmp;
        }
        // c->a
        if (c.now <= a.capa - a.now) {
            int tmp = c.now;
            a.now += tmp;
            c.now = 0;
            dfs(a, b, c);
            c.now = tmp;
            a.now -= tmp;
        } else {
            int tmp = a.now;
            a.now = a.capa;
            c.now -= a.capa - tmp;
            dfs(a, b, c);
            c.now += a.capa - tmp;
            a.now = tmp;
        }
        // c->b
        if (c.now <= b.capa - b.now) {
            int tmp = c.now;
            b.now += tmp;
            c.now = 0;
            dfs(a, b, c);
            c.now = tmp;
            b.now -= tmp;
        } else {
            int tmp = b.now;
            b.now = b.capa;
            c.now -= b.capa - tmp;
            dfs(a, b, c);
            c.now += b.capa - tmp;
            b.now = tmp;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Glass a = new Glass(Integer.parseInt(st.nextToken()));
        Glass b = new Glass(Integer.parseInt(st.nextToken()));
        int tmp = Integer.parseInt(st.nextToken());
        Glass c = new Glass(tmp, tmp);


        visited = new boolean[201][201][201];
        ans = new HashSet<>();
        dfs(a, b, c);
        ans.stream().sorted().forEach((e) -> sb.append(e).append(" "));
        System.out.print(sb);


    }
}
