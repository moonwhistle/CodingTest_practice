import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // setting
        int N = input.nextInt();
        int d = input.nextInt(); // 초밥 가짓수
        int k = input.nextInt(); // 연속 접시
        int c = input.nextInt(); // 보너스

        int[] foods = new int[N];

        for (int i = 0; i < N; i++) {
            foods[i] = input.nextInt();
        }

        // get food
        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> foodCount = new HashMap<>();

        for (int i = 0; i < N + k - 1; i++) {
            int now = foods[i % N];

            if (i >= k) {
                int poll = queue.poll();
                int value = foodCount.get(poll) - 1;
                foodCount.put(poll, value);

                if (foodCount.get(poll) == 0) {
                    foodCount.remove(poll);
                }
            }
            queue.add(now);
            foodCount.put(now, foodCount.getOrDefault(now, 0) + 1);

            int size = foodCount.size();

            if (!foodCount.containsKey(c)) {
                size++;
            }

            max = Math.max(max, size);
        }

        System.out.println(max);
    }
}
