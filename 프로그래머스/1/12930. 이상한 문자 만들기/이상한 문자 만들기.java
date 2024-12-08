class Solution {
    public String solution(String s) {
        int index = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; ++i) {
            if(arr[i] == ' ') {
                index = 0;
            } else {
                if((index & 1) == 0) {
                    if(arr[i] > 96) {
                        arr[i] ^= 32;
                    }
                } else {
                    if(arr[i] < 97) {
                        arr[i] ^=32;
                    }
                }
                index++;
            }
        }
        return String.valueOf(arr);
    }
}