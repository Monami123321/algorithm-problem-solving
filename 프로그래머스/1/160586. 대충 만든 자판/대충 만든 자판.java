import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] arr = new int[128];
        final int INF = 1 << 20;
        Arrays.fill(arr, INF);
        for(String s : keymap) {
            int n = s.length();
            for(int i = 0; i < n; ++i) {
                char tmp = s.charAt(i);
                arr[tmp] = Math.min(arr[tmp], i + 1);
            }
        }
        int[] ans = new int[targets.length];
        int index = 0;
        for(String s : targets) {
            int sum = s.chars().map(e -> arr[e]).sum();
            ans[index++] = sum >= INF ? -1 : sum;
        }
        return ans;
    }
}