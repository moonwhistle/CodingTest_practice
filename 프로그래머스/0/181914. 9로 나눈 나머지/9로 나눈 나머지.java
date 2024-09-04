class Solution {
    public int solution(String number) {
       int answer = 0;
        for (char num : number.toCharArray()) {
            answer += Integer.parseInt(String.valueOf(num));
        }
        answer %= 9;

        return answer;
    }
}