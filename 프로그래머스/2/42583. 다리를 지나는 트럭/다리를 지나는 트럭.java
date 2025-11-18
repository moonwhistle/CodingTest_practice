import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> trucks = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            trucks.add(new Truck(truck_weight, 0));
        }

        int bridgeWeight = 0;
        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            if (!bridge.isEmpty() && bridge.peek().place() >= bridge_length) {
                Truck truck = bridge.poll();
                bridgeWeight -= truck.weight();
            }

            for (Truck truck : bridge) {
                truck.add();
            }

            if (!trucks.isEmpty() && trucks.peek().weight() + bridgeWeight <= weight) {
                Truck truck = trucks.poll();
                truck.add();
                bridgeWeight += truck.weight();
                bridge.add(truck);
            }

            answer++;
        }

        System.out.println(answer);
        return answer;
    }
}

class Truck {

    private final int weight;
    private int place;


    Truck(int weight, int place) {
        this.weight = weight;
        this.place = place;
    }

    public int weight() {
        return this.weight;
    }

    public int place() {
        return this.place;
    }

    public void add() {
        this.place++;
    }
}
