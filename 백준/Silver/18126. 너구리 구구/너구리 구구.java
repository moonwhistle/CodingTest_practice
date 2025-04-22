import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static ArrayList<long[]>[] rooms;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        rooms = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        // 세팅
        for (int i = 1; i < N + 1; i++) {
            rooms[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();

            rooms[start].add(new long[]{end, weight});
            rooms[end].add(new long[]{start, weight});
        }

        System.out.println(bfs(1));
    }

    private static long bfs(int start) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{start, 0});
        visited[start] = true;
        long max = 0;

        while (!queue.isEmpty()) {
            long[] current = queue.poll();

            max = Math.max(max, current[1]);

            for (long[] room : rooms[(int) current[0]]) {
                int next = (int) room[0];
                long weight = room[1];

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new long[]{next, current[1] + weight});
                }
            }
        }

        return max;
    }
}
