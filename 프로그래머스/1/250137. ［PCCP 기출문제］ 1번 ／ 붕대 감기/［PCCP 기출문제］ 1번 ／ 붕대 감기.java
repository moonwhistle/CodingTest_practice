class Solution {

    // 전체 시간은 계속 증가 하도록
    // 시간에 따라 attack 을 확인하며 해당 attack 이 있으면 반영
    // 만일 마지막 attack 이면 종료, 피가 0 이하이면 종료

    static int time = 0;
    static int currentAttackTime;
    static int currentDamage;
    static int successTime = 1;

    public static int solution(int[] bandage, int health, int[][] attacks) {
        return playGame(health, attacks, bandage);
    }

    private static int playGame(int health, int[][] attacks, int[] bandage) {
        int nowHealth = health;

        while(true) {
            if(isAttack(attacks)) { // 공격 받았을 경우
                nowHealth -= currentDamage;
                successTime = 0;

                if(nowHealth <= 0) { // 사망
                    return -1;
                }
            } else { // 공격 안받았을 경우
                nowHealth += bandage[1]; // 초당 회복
                nowHealth = checkNowHealthOverOriginalHealth(nowHealth, health);

                if (successTime== bandage[0]) { // 성공 시간 도달 시 추가 회복
                    nowHealth += bandage[2];
                    nowHealth = checkNowHealthOverOriginalHealth(nowHealth, health);
                    successTime = 0; //0부터 시작되도록
                }
            }

            if(isLast(attacks)) {
                break;
            }

            time++;
            successTime++;
        }

        return nowHealth;
    }

    private static int checkNowHealthOverOriginalHealth(int nowHealth, int health) {
        return Math.min(nowHealth, health);
    }

    private static boolean isAttack(int[][] attacks) {
        for (int[] attack : attacks) {
            if (attack[0] == time) { // 공격에 해당되는 시간이라면
                currentAttackTime = attack[0];
                currentDamage = attack[1];
                return true;
            }
        }

        return false;
    }

    private static boolean isLast(int[][] attacks) {
        return time == attacks[attacks.length - 1][0];
    }
}
