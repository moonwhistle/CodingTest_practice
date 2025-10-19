import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    private static int[][] map;
    private static int[][] distance;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int test = 1; test <= T; test++) {
            // setting
            int N = input.nextInt();
            map = new int[N][N];
            distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = input.next();

                int j = 0;
                for (String lineElement : line.split("")) {
                    map[i][j] = Integer.parseInt(lineElement);
                    distance[i][j] = Integer.MAX_VALUE;
                    j++;
                }
            }

            dijkstra(0, 0);
            System.out.println("#" + test + " " + distance[N - 1][N - 1]);
        }
    }

    private static void dijkstra(int startX, int startY) {
        distance[startY][startX] = map[startY][startX];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startY, startX, map[startX][startX]));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.Y;
            int x = node.X;
            int weight = node.weight;

            if (weight > distance[y][x]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int cY = y + dy[i];
                int cX = x + dx[i];

                if (cX < 0 || cY < 0 || cY >= map.length || cX >= map.length) {
                    continue;
                }

                int newWight = weight + map[cY][cX];
                if (newWight < distance[cY][cX]) {
                    distance[cY][cX] = newWight;
                    queue.offer(new Node(cY, cX, newWight));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    int Y;
    int X;
    int weight;

    public Node(int Y, int X, int weight) {
        this.Y = Y;
        this.X = X;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}
