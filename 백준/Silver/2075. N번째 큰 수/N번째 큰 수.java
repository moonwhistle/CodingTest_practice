import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N * N; i++) {
            int num = input.nextInt();

            pq.add(num);

            if (pq.size() > N) {
                pq.poll();
            }
        }

        System.out.println(pq.peek());
    }
}
