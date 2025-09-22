import java.util.ArrayList;
import java.util.List;

class Solution {

    static int[] first = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
    static int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    static int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] count = new int[4];
        int idx = 0;

        while(idx != answers.length) {
            if(answers[idx] == first[idx % 10]) {
                count[1]++;
            }
            if(answers[idx] == second[idx % 8]) {
                count[2]++;
            }
            if(answers[idx] == third[idx % 10]) {
                count[3]++;
            }
            
            idx++;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i<4; i++) {
            max = Math.max(count[i], max);
        }

        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i<4; i++) {
            if(count[i] == max) {
                answer.add(i);
            }
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
