class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int attackIndex = 0;
        int healthMax = health;
        int heal = 0;
        int t = 0;
        outer:while(attackIndex<attacks.length) {
            t++;
            heal++;
            if(t == attacks[attackIndex][0]) {
                health -= attacks[attackIndex++][1];
                if(health<=0) {
                    return -1;
                }
                heal = 0;
                continue outer;
            }
            health += bandage[1];
            if(heal == bandage[0]) {
                health += bandage[2];
                heal = 0;
            }
            if(health > healthMax) {
                health = healthMax;
            }
        }
        return health;
    }
}