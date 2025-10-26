import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static int[] dx = {1, -1, 0};
    static int[] dy = {0, 0, -1};
    static int[][] map = new int[100][100];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int testCase = input.nextInt();

            for (int y = 0; y < 100; y++) {
                for (int x = 0; x < 100; x++) {
                    map[y][x] = input.nextInt();
                }
            }

            List<Point> starts = findEnds();
            boolean[][] visited;

            for (Point point : starts) {
                visited = new boolean[100][100];
                dfs(99, point.x, point, visited);
            }

            Collections.sort(starts);

            System.out.println("#" + testCase + " " + starts.get(0).x);
        }
    }

    private static void dfs(int y, int x, Point point, boolean[][] visited) {
        while (y > 0) {
            visited[y][x] = true;

            if (x > 0 && map[y][x-1] == 1 && !visited[y][x-1]) {
                x--;
            } else if (x < 99 && map[y][x+1] == 1 && !visited[y][x+1]) {
                x++;
            } else {
                y--;
            }

            point.move();
        }

        point.x = x;
    }

    private static List<Point> findEnds() {
        List<Point> ends = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            if (map[99][i] == 1) {
                ends.add(new Point(i));
            }
        }

        return ends;
    }
}

class Point implements Comparable<Point> {

    int x;
    int moveCount;

    public Point(int x) {
        this.x = x;
        this.moveCount = 0;
    }

    public void move() {
        this.moveCount++;
    }

    @Override
    public int compareTo(Point o) {
        return this.moveCount - o.moveCount;
    }
}
