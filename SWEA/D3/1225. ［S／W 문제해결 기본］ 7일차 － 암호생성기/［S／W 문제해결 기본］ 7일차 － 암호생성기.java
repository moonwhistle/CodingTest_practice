import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int t = 1; t <= 10; t++) {
            int T = input.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                queue.offer(input.nextInt());
            }

            int minus = 1;

            while (queue.peek() - minus > 0) {
                int num = queue.poll() - minus;
                queue.offer(num);
                minus = minus % 5 + 1;
            }

            queue.poll();
            queue.offer(0);

            System.out.print("#" + T + " ");
            for (int num : queue) {
                System.out.print(num + " ");
            }
        }
    }
}
