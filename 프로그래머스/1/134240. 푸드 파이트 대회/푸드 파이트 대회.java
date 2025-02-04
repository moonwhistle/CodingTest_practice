import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        //세팅
        Queue<Integer> count = new LinkedList<>();
        for (int i = 0; i < food.length; i++) {
            if (i == 0) {
                count.add(i);
            }
            if (food[i] > 1) {
                for (int j = 0; j < food[i] / 2; j++) {
                    count.add(i);
                }
            }
        }

        int[] sequence = new int[(count.size() - 1) * 2 + 1];
        sequence[sequence.length  /2 ] = count.poll();

        for(int i = 0; i< sequence.length/2; i++) {
            sequence[sequence.length - 1 -i] = count.peek();
            sequence[i] = count.poll();
        }

        for(int i : sequence) {
            answer.append(i);
        }
        return answer.toString();
    }
}
