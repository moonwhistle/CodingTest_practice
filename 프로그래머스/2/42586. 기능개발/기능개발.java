import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Solution {

    // stack 에 값 넣어주고
    // count 세줌
    // (count * speed) + prog 가 100 넘는지 확인

    static Queue<Integer> proSt = new LinkedList<>();
    static Queue<Integer> spSt = new LinkedList<>();

    public int[] solution(int[] progresses, int[] speeds) {
        setting(progresses, speeds);
        Map<Integer, Integer> completeCount = new TreeMap<>();

        int count = 1;

        while (!proSt.isEmpty()) {
            if (proSt.peek() + count * spSt.peek() >= 100) {
                completeCount.put(count, completeCount.getOrDefault(count, 0) + 1);
                proSt.poll();
                spSt.poll();
            } else {
                count++;
            }
        }

        int[] answer = new int[completeCount.size()];
        
        int idx = 0;
        for(int i : completeCount.values()) {
            answer[idx] = i;
            idx++;
        }
        
        return answer;
    }

    private void setting(int[] progresses, int[] speeds) {
        for (int i : progresses) {
            proSt.add(i);
        }

        for (int i : speeds) {
            spSt.add(i);
        }
    }
}
