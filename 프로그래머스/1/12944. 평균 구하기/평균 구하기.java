class Solution {

    public static double solution(int[] arr) {
        double answer = 0;

        for(int i : arr) {
            answer += i;
        }
        return answer / arr.length;
    }
}
