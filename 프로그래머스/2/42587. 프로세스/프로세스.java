import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        //세팅
        int size = priorities.length;
        Queue<Integer> locationQueue = new LinkedList<>();
        for(int i = 0; i<size; i++) {
            if(location == i) {
                locationQueue.add(1);
            } else {
                locationQueue.add(0);
            }
        }
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> priorityQueue = new LinkedList<>();
        for(int priority : priorities) {
            max.add(priority);
            priorityQueue.add(priority);
        }

        //로직
        while (locationQueue.contains(1)) {
            int process = priorityQueue.poll();
            int now = locationQueue.poll();

            if(process == max.peek()) {
                answer++;
                max.poll();
            } else {
                priorityQueue.add(process);
                locationQueue.add(now);
            }
        }

        return answer;
    }
}
