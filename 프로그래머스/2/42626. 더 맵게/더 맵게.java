import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = setPq(scoville);

        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                return answer;
            }

            int first = pq.poll();
            int second = pq.poll();

            pq.add(first + (second * 2));
            answer++;
        }

        if (pq.peek() > K) {
            return answer;
        }

        return -1;
    }

    private PriorityQueue<Integer> setPq(int[] scoville) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int sc : scoville) {
            pq.add(sc);
        }

        return pq;
    }
}
