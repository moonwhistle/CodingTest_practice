class Solution {

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        //세팅
        int[] measureNumber = new int[number + 1];

        //number 순회
        for (int i = 1; i <= number; i++) {
            int count = getMeasureCount(i);
            measureNumber[i] = count;
        }

        for (int i : measureNumber) {
            if (i > limit) {
                answer += power;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    private static int getMeasureCount(int number) {
        int count = 1;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }
}
