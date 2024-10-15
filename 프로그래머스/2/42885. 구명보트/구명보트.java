import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int cnt = 0;
        int w;
        while(left <= right) {
            w = people[left] + people[right];
            cnt++;
            if(w <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
        }
        return cnt;
    }
}