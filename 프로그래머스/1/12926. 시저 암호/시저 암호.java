class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; ++i) {
            if(arr[i] == ' ') {
                continue;
            }
            if(arr[i] < 97) {
                arr[i] = (char)((arr[i] - 65 + n) % 26 + 65);
            } else {
                arr[i] = (char)((arr[i] - 97 + n) % 26 + 97);
            }
        }
        return String.valueOf(arr);
    }
}