import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        int[] line = new int[100001];
        boolean[] visited = new boolean[100001];
        line[N] = 0;
        visited[N] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int number = queue.poll();

            if (number == K) {
                System.out.println(line[K]);
            }

            int[] nexts = {number - 1, number + 1, 2 * number};

            for (int next : nexts) {
                if (next >= 0 && next < line.length && !visited[next]) {
                    queue.add(next);
                    line[next] = line[number] + 1;
                    visited[next] = true;
                }
            }
        }
    }
}
