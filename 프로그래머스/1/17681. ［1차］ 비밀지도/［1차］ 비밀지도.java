import java.util.stream.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int len = arr1.length;
        return IntStream.range(0, len)
            .mapToObj(i-> {
                int tmp = arr1[i] | arr2[i];
                StringBuilder sb = new StringBuilder();
                for(int j = len - 1; j>=0;--j) {
                    if((tmp & (1<<j)) == 0) {
                        sb.append(" ");
                    } else {
                        sb.append("#");
                    }
                }
                return sb.toString();
            })
            .toArray(String[]::new);   
    }
}