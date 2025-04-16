class Solution {
    public static String solution(String s) {
        String answer = "";

        boolean isStart = true;

        for(char element : s.toCharArray()) {
            if(isStart) {
                if(Character.isLetter(element)) { // 문자일 경우
                    char string = Character.toUpperCase(element);
                    answer += string;
                } else { // 숫자일 경우
                    answer += element;
                }
            }

            if(!isStart) {
                if(Character.isLetter(element)) { // 문자일 경우
                    char string = Character.toLowerCase(element);
                    answer += string;
                } else { // 공백일 경우
                    answer += element;
                }
            }

            if(element != ' ') {
                isStart = false;
            } else {
                isStart = true;
            }
        }

        return answer;
    }
}