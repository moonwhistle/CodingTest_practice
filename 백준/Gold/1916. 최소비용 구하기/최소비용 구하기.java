import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int N = input.nextInt();
        int M = input.nextInt();

        List<Bus>[] buses = new ArrayList[N + 1];
        int[] prices = new int[N + 1];

        Arrays.fill(prices, Integer.MAX_VALUE);

        for (int i = 1; i < N + 1; i++) {
            buses[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int price = input.nextInt();

            buses[start].add(new Bus(end, price));
        }

        int start = input.nextInt();
        int end = input.nextInt();

        prices[start] = 0;

        boolean[] visited = new boolean[N + 1];

        // logic
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        queue.add(new Bus(start, 0));

        while (!queue.isEmpty()) {
            Bus nowBus = queue.poll();

            if (visited[nowBus.to]) {
                continue;
            }

            visited[nowBus.to] = true;

            if (visited[end]) {
                System.out.println(prices[end]);
                break;
            }

            for (Bus bus : buses[nowBus.to]) {
                if (prices[bus.to] > prices[nowBus.to] + bus.price) {
                    prices[bus.to] = prices[nowBus.to] + bus.price;
                    queue.add(new Bus(bus.to, prices[bus.to]));
                }
            }
        }

    }
}

class Bus implements Comparable<Bus> {
    int to;
    int price;

    public Bus(int to, int price) {
        this.to = to;
        this.price = price;
    }

    @Override
    public int compareTo(Bus other) {
        return this.price - other.price;
    }
}
