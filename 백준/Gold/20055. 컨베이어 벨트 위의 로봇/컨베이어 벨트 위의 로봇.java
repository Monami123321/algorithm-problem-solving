import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Belt {
        boolean isRobot;
        int capa;

        public Belt(int capa) {
            this.capa = capa;
        }
    }

    static int n, zero;
    static Belt[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        zero = Integer.parseInt(st.nextToken());
        arr = new Belt[n << 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < (n << 1); i++) {
            arr[i] = new Belt(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        while (zero > 0) {
            ans++;
            beltMove();
            robotMove();
            if (arr[0].capa != 0) {
                arr[0].isRobot = true;
                arr[0].capa--;
                if (arr[0].capa == 0) {
                    zero--;
                }
            }

        }
        System.out.println(ans);


        br.close();
    }

    static void beltMove() {
        Belt prev = arr[0];
        for (int i = 1; i < n * 2; i++) {
            Belt tmp = arr[i];
            arr[i] = prev;
            prev = tmp;
        }
        arr[0] = prev;
        if (arr[n - 1].isRobot) {
            arr[n - 1].isRobot = false;
        }
    }

    static void robotMove() {
        for (int i = n - 2; i >= 0; i--) {
            if (!arr[i].isRobot) {
                continue;
            }
            if (arr[i + 1].isRobot || arr[i + 1].capa == 0) {
                continue;
            }
            arr[i].isRobot = false;
            arr[i + 1].isRobot = true;
            arr[i + 1].capa--;
            if (arr[i + 1].capa == 0) {
                zero--;
            }
        }
        if (arr[n - 1].isRobot) {
            arr[n - 1].isRobot = false;
        }
    }
}
