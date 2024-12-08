class Solution {
    public long solution(int price, int money, int count) {
        long sum = (long)count * (count + 1) * price >> 1;
        return money >= sum ? 0 : sum - money;
    }
}