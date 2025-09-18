import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static Queue<Truck> waiting = new LinkedList<>();
    static Queue<Truck> bridge = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        setting(truck_weights);
        int nowWeight =0;

        while(!bridge.isEmpty() || !waiting.isEmpty()) {
            int removeCount = 0;

            for(Truck truck : bridge) {
                truck.move();

                if(truck.place > bridge_length) {
                    removeCount++;
                }
            }

            for(int i = 0 ; i<removeCount; i++) {
                Truck truck = bridge.poll();
                nowWeight -= truck.weight;
            }

            if(!waiting.isEmpty()) {
                if(nowWeight + waiting.peek().weight <= weight) {
                    nowWeight += waiting.peek().weight;
                    Truck truck = waiting.poll();
                    truck.move();
                    bridge.add(truck);
                }
            }

            answer++;
        }

        return answer;
    }

    private void setting(int[] truck_weights) {
        for(int i : truck_weights) {
            waiting.add(new Truck(0, i));
        }
    }
}

class Truck {
    int place;
    int weight;

    public Truck(int place, int weight) {
        this.place = place;
        this.weight = weight;
    }

    public void move() {
        this.place++;
    }
}
