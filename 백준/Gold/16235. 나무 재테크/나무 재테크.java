import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int nutrition, prev;
        List<Integer> list;

        public Node() {
            this.nutrition = 5;
            this.list = new ArrayList<>();
        }
    }

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 맵 크기
        int m = Integer.parseInt(st.nextToken()); // 초기 나무 갯수
        int k = Integer.parseInt(st.nextToken()); // 연도
        Node[][] map = new Node[n][n];
        int[][] robot = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = new Node();
                robot[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            map[r][c].list.add(age);
        }

        while (k-- > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Node node = map[i][j];
                    Collections.sort(node.list);
                    int len = node.list.size();
                    for (int l = 0; l < len; l++) {
                        int now = node.list.get(l);
                        if (now <= node.nutrition) {
                            node.nutrition -= now++;
                            node.list.set(l, now);
                        } else {
                            node.list.remove(l--);
                            len--;
                            node.prev += now >> 1;
                        }
                    }

                }
            } // 봄

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j].nutrition += map[i][j].prev + robot[i][j];
                    map[i][j].prev = 0;
                    for (int tmp : map[i][j].list) {
                        if (tmp % 5 == 0) {
                            for (int l = 0; l < 8; l++) {
                                int nr = i + dr[l];
                                int nc = j + dc[l];
                                if (nr < 0 || nr > n - 1 || nc < 0 || nc > n - 1) {
                                    continue;
                                }
                                map[nr][nc].list.add(1);
                            }
                        }
                    }
                }
            } // 여름 가을 겨울

        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += map[i][j].list.size();
            }
        }
        System.out.println(ans);
        br.close();
    }
}
