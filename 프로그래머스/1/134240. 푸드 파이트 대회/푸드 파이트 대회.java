class Solution {
    public String solution(int[] food) {
        int len = 1;
        for(int i = 1; i<food.length; ++i) {
            if((food[i] & 1) != 0) {
                food[i]--;
            }
            len += food[i];
        }
        char[] arr = new char[len];
        arr[len >> 1] = 48;
        int index = 0;
        for(int i = 1; i<food.length; ++i) {
            while(food[i] > 0) {
                arr[index] = arr[len-1-index] = (char)(i + 48);
                index++;
                food[i] -= 2;
            }
        }
        return String.valueOf(arr);
    }
}