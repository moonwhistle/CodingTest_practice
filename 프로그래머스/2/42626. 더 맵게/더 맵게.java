import java.util.PriorityQueue;

class Solution {

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : scoville) {
            queue.add(num);
        }

        int count = 0;

        while (queue.peek() < K) {
            if(queue.size() == 1) {
                return -1;
            }
            count++;
            int first = queue.poll();
            int second = queue.poll();
            int newScoville = first + (second * 2);
            queue.add(newScoville);
        }
        return count;
    }
}
