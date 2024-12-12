import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] arr = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] sum = new int[3];
        for(int i = 0; i<answers.length;++i) {
            if(arr[0][i % 5] == answers[i]) {
                sum[0]++;
            }
            if(arr[1][i % 8] == answers[i]) {
                sum[1]++;
            }
            if(arr[2][i % 10] == answers[i]) {
                sum[2]++;
            }
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i<3; ++i) {
            list.add(new int[] {i+1,sum[i]});
        }
        Collections.sort(list,(a,b)-> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        for(int i = 2; i>=1; --i) {
            if(list.get(i)[1] != list.get(0)[1]) {
                list.remove(i);
            }
        }
        return list.stream().mapToInt(a->a[0]).toArray();
    }
}