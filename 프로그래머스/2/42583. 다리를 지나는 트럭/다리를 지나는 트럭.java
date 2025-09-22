import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static Queue<Truck> bridge = new LinkedList<>();
    static Queue<Truck> waiting = new LinkedList<>();

    public static void main(String[] args) {
        solution(2, 10, new int[]{7, 4, 5, 6});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        setting(truck_weights);

        int currentWeight = 0;
        while (!bridge.isEmpty() || !waiting.isEmpty()) {
            for (Truck truck : bridge) {
                truck.move();
            }

            if (!bridge.isEmpty() && bridge.peek().place > bridge_length) {
                Truck truck = bridge.poll();
                currentWeight -= truck.weight;
            }

            if (!waiting.isEmpty() && currentWeight + waiting.peek().weight <= weight) {
                Truck truck = waiting.poll();
                truck.move();
                bridge.add(truck);
                currentWeight += truck.weight;
            }

            answer++;
        }

        System.out.println(answer);
        return answer;
    }

    private static void setting(int[] truck_weights) {
        for (int i : truck_weights) {
            waiting.add(new Truck(0, i));
        }
    }
}

class Truck {
    int place;
    int weight;

    public Truck(int place, int weight) {
        this.weight = weight;
        this.place = place;
    }

    public void move() {
        this.place++;
    }
}
