import java.util.PriorityQueue;

class Solution {

    public static int[] solution(int k, int[] score) {
        int[] answer;
        //세팅
        PriorityQueue<Integer> honor = new PriorityQueue<>();
        answer = new int[score.length];

        for(int i = 0; i<score.length; i++) {
            honor.add(score[i]);

            if(honor.size() > k) {
                honor.poll();
            }
            
            answer[i] = honor.peek();
        }
        
        return answer;
    }
}
