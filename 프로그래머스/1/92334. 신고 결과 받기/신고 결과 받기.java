import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        Map<String, Integer> hm = IntStream.range(0, n)
            .boxed().collect(Collectors.toMap(e -> id_list[e], Function.identity()));
        Set<String>[] sets = new HashSet[n];
        for(int i = 0; i<n; ++i) {
            sets[i] = new HashSet<>();
        }
        StringTokenizer st;
        for(String s : report) {
            st = new StringTokenizer(s);
            String a = st.nextToken();
            String b = st.nextToken();
            sets[hm.get(b)].add(a);
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i) {
            if(sets[i].size() >= k) {
                sets[i].stream().forEach(e->ans[hm.get(e)]++);
            }
        }
        return ans;
    }
}