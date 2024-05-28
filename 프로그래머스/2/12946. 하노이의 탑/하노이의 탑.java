import java.util.*;
class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(1, 2, 3, n);
        // return list.stream().toArray(size-> new int[size][2]);
        return list.toArray(new int[0][]);
    }
    static void hanoi(int from, int tmp, int to, int n) {
        if(n == 1) {
            list.add(new int[] {from, to});
            return;
        }
        hanoi(from, to, tmp, n - 1);
        list.add(new int[] {from, to});
        hanoi(tmp, from, to, n - 1);
    }
}