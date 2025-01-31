import java.text.ParseException;
import java.util.Arrays;

class Solution {

    public static int[] solution(String[] keymap, String[] targets) {
        // target 길이 만큼 정답 개수 생성
        int[] answer = new int[targets.length];

        //target 을 기준으로 전체 반복문
        for(int i = 0; i<targets.length; i++) {
            int sum = 0;
            for(char c : targets[i].toCharArray()) {
                int min = Integer.MAX_VALUE;
                boolean found = false;
                for (String s : keymap) {
                    int pressCount = s.indexOf(c) + 1;
                    if (pressCount != 0) {
                        found = true;
                        min = Math.min(min, pressCount);
                    }
                }
                if(found) {
                    sum += min;
                } else {
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
