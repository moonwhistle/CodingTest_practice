import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        //세팅
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();
        for (int progress : progresses) {
            progressQueue.add(progress);
        }
        for(int speed : speeds) {
            speedQueue.add(speed);
        }
        List<Integer> complete = new ArrayList<>();

        //로직
        while (!progressQueue.isEmpty()) {
            int count = 0;

            for (int i = 0; i < progressQueue.size(); i++) {
                int progress = progressQueue.poll();
                int speed = speedQueue.poll();
                progressQueue.add(progress + speed);
                speedQueue.add(speed);
            }

            while(!progressQueue.isEmpty() && progressQueue.peek() >= 100) {
                progressQueue.poll();
                speedQueue.poll();
                count++;
            }

            if(count > 0) {
                complete.add(count);
            }
        }

        answer = complete.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}
