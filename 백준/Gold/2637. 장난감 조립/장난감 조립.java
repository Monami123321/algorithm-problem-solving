import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Component {
        int id;
        HashMap<Integer, Integer> child;
        TreeMap<Integer, Integer> basic;

        public Component(int id) {
            this.id = id;
            this.child = new HashMap<>();
            this.basic = new TreeMap<>();

        }
    }


    static int N, M;
    static Component[] components;


    static TreeMap<Integer, Integer> dfs(Component component) {
        if (component.child.isEmpty()) {
            return component.basic;
        }


        if (component.basic.isEmpty()) {
            Set<Integer> keySet = component.child.keySet();
            for (int key : keySet) {
                TreeMap<Integer, Integer> tmp = dfs(components[key]);

                Set<Integer> tmpSet = tmp.keySet();

                for (int tmpKey : tmpSet) {
                    if (component.basic.get(tmpKey) == null) {
                        component.basic.put(tmpKey, tmp.get(tmpKey) * component.child.get(key));

                    } else {
                        component.basic.put(tmpKey, component.basic.get(tmpKey) + tmp.get(tmpKey) * component.child.get(key));
                    }
                }
            }

        }
        return component.basic;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        components = new Component[N + 1]; // 1번인덱스가 시작, N번이 완제품

        for (int i = 1; i < N + 1; i++) {
            components[i] = new Component(i);

        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x를 만드는데
            int y = Integer.parseInt(st.nextToken()); // y가
            int k = Integer.parseInt(st.nextToken()); // k개 필요

            components[x].child.put(y, k);


        }

        for (int i = 1; i < N + 1; i++) {
            if (components[i].child.isEmpty()) {
                components[i].basic.put(components[i].id, 1);
            }

        }

        TreeMap<Integer, Integer> ans = dfs(components[N]);

        ans.forEach((k, v) -> sb.append(k).append(" ").append(v).append("\n"));

        System.out.print(sb);


    }


}
