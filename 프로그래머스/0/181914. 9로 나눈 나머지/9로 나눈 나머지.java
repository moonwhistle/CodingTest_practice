class Solution {
    public int solution(String number) {
        int answer = 0;
        int sumNum = 0;
        for (char num : number.toCharArray()) {
            sumNum += Integer.parseInt(String.valueOf(num));
        }
        answer = sumNum % 9;

        return answer;
    }
}