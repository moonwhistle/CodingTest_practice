import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //세팅
        Queue<Integer> trucks = new LinkedList<>();
        for (int i : truck_weights) {
            trucks.add(i);
        }
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        int currentWeight = 0;

        //로직
        while(!trucks.isEmpty() || currentWeight > 0) {
            int front = bridge.poll();
            currentWeight -= front;
            if(!trucks.isEmpty() && trucks.peek() + currentWeight <= weight) {
                int truck = trucks.poll();
                bridge.add(truck);
                currentWeight += truck;
            } else {
                bridge.add(0);
            }
            answer++;
        }
        
        return answer;
    }
}
