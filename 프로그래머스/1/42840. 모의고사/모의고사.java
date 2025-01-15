import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;

        for(int i = 0; i<answers.length ; i ++) {
            if(answers[i] == one[i % one.length]) {
                oneCount++;
            }
            if(answers[i] == two[i % two.length]) {
                twoCount++;
            }
            if(answers[i] == three[i % three.length]) {
                threeCount++;
            }
        }

        int oneBetweenTwoMax = Math.max(oneCount, twoCount);
        int max = Math.max(oneBetweenTwoMax, threeCount);

        if(max == oneCount) {
            answer.add(1);
        }
        if(max == twoCount) {
            answer.add(2);
        }
        if(max == threeCount) {
            answer.add(3);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}