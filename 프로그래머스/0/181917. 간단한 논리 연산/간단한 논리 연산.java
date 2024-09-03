class Solution {
    public static boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
        boolean firstCalculation = true;
        boolean secondCalculation = true;
        if (x1 == x2) {
            if (!x1) {
                firstCalculation = false;
            }
        }
        if (x3 == x4) {
            if (!x3) {
                secondCalculation = false;
            }
        }
        if (firstCalculation == secondCalculation) {
            if (!firstCalculation) {
                answer = false;
            }
        } else {
            answer = false;
        }
        return answer;
    }
}