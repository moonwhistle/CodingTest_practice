import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        visited = new boolean[maps.length][maps[0].length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            if (poll.x == maps[0].length - 1 && poll.y == maps.length - 1) {
                answer = Math.min(answer, poll.count);
            }

            for (int i = 0; i < 4; i++) {
                int x = poll.x + dx[i];
                int y = poll.y + dy[i];

                if (x >= 0 && y >= 0 && x < maps[0].length && y < maps.length && maps[y][x] == 1) {
                    if (!visited[y][x]) {
                        visited[y][x] = true;
                        queue.add(new Point(x, y, poll.count + 1));
                    }
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }
}

class Point {

    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
