import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int treeSize = 0;
        for (int i = 20; i >= 0; i--) {
            int tmp = n & (1 << i);
            if (tmp != 0) {
                if (tmp == n) {
                    treeSize = tmp << 1;
                } else {
                    treeSize = tmp << 2;
                }
                break;
            }
        } // 2^k >= n 을 만족하는 k 에서 2^(k+1)만큼 배열의 크기를 잡는다. 맨 아래쪽에 실제 값을 넣는다.
        long[] segTree = new long[treeSize];
        int treeStartIndex = treeSize >> 1;
        for (int i = 0; i < n; i++) {
            segTree[(treeStartIndex) + i] = Long.parseLong(br.readLine());
        } // 세그먼트트리 리프노드 입력함
        for (int i = treeSize - 1; i >= 2; i--) {
            segTree[i >> 1] += segTree[i];
        } // 구간 합 구함


        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            if (cmd == 1) { // 값 변경인 경우
                start += treeStartIndex - 1; // 인덱스를 찾아가고
                long diff = end - segTree[start]; // 차이를 구하고
                segTree[start] = end; // 일단 값을 바꾼다
                while (start > 1) { // 이진트리를 거꾸로 올라가면서 모두 변경
                    start >>= 1;
                    segTree[start] += diff;
                }
            } else { // 구간합구할경우
                long sum = 0;
                start += treeStartIndex - 1;
                end += treeStartIndex - 1;
                while (end >= start) { // 이진트리 위로 올라가며 구간합 계산하기
                    if ((start & 1) != 0) {
                        sum += segTree[start];
                        start = (start + 1) >> 1;

                    } else {
                        start = (start + 1) >> 1;
                    }

                    if ((end & 1) == 0) {
                        sum += segTree[(int) end];
                        end = (end - 1) >> 1;
                    } else {
                        end = (end - 1) >> 1;
                    }
                }
                sb.append(sum).append("\n");
            }
        }

        System.out.print(sb);


        br.close();

    }
}
