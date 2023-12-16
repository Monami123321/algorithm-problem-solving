import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Wheel {
        Wheel left;
        Wheel right;
        int[] arr;
        int pointer;

        public Wheel(int[] arr) {
            this.arr = arr;
        }
    }

    static Wheel[] wheels;

    static void dfs(Wheel wheel, int ref, int dir, int magnet) {
        int nextDir = dir * -1;
        if (ref == 0) {
            // 다음바퀴 재귀 ref 0 -> 시작 1 -> 오른쪽에서 왔음 -1 -> 왼쪽에서 왔음
            if (wheel.left != null) {
                dfs(wheel.left, 1, nextDir, wheel.arr[(wheel.pointer + 6) % 8]);
            }
            if (wheel.right != null) {
                dfs(wheel.right, -1, nextDir, wheel.arr[(wheel.pointer + 2) % 8]);
            }
            // 이 바퀴 돌리기
            if (dir == 1) {
                wheel.pointer = (wheel.pointer + 7) % 8;

            } else {
                wheel.pointer = (wheel.pointer + 1) % 8;
            }

        } else if (ref == 1) {
            if (magnet == wheel.arr[(wheel.pointer + 2) % 8]) {
                return;
            }
            if (wheel.left != null) {
                dfs(wheel.left, 1, nextDir, wheel.arr[(wheel.pointer + 6) % 8]);
            }

            if (dir == 1) {
                wheel.pointer = (wheel.pointer + 7) % 8;

            } else {
                wheel.pointer = (wheel.pointer + 1) % 8;
            }

        } else {
            if (magnet == wheel.arr[(wheel.pointer + 6) % 8]) {
                return;
            }
            if (wheel.right != null) {
                dfs(wheel.right, -1, nextDir, wheel.arr[(wheel.pointer + 2) % 8]);
            }
            if (dir == 1) {
                wheel.pointer = (wheel.pointer + 7) % 8;

            } else {
                wheel.pointer = (wheel.pointer + 1) % 8;
            }

        }


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        wheels = new Wheel[4];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), "01", true);
            int[] arr = new int[8];
            for (int j = 0; j < 8; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            wheels[i] = new Wheel(arr);
        }

        for (int i = 0; i < 3; i++) {
            wheels[i].right = wheels[i + 1];
            wheels[3 - i].left = wheels[2 - i];
        }

        int rotateLoop = Integer.parseInt(br.readLine());
        for (int i = 0; i < rotateLoop; i++) {
            st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            dfs(wheels[wheelNum], 0, dir, 0);

        }
        int ans = 0;
        for (int i = 0, score = 1; i < 4; i++) {
            if (wheels[i].arr[wheels[i].pointer] != 0) {
                ans += score;
            }
            score *= 2;
        }

        System.out.println(ans);


    }
}
