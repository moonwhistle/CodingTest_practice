import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    static int count = 0;

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> progressQueue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            progressQueue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }

        while (!progressQueue.isEmpty()) {
            count++;
            int doneCount = 0;

            while (!progressQueue.isEmpty() && progressQueue.peek() + (speedQueue.peek() * count) >= 100) {
                doneCount++;
                progressQueue.poll();
                speedQueue.poll();
            }

            if (doneCount != 0) {
                answer.add(doneCount);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
