import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static List<int[]> points;
    static int[][] map;
    static int[] initial;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[12][16];
        points = new ArrayList<>();
        min = m;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = a + 1;
            map[a + 1][b] = a;
            points.add(new int[]{a, b});
        }

        initial = reach();
        // Please write your code here.
        for (int i = m; i >= 0; i--) {
            btk(i, 0, 0);
        }

        System.out.println(min);
    }

    private static void btk(int size, int count, int idx) {
        if (min != m) {
            return;
        }

        if (count == size) {
            int[] result = reach();

            for (int i = 0; i < result.length; i++) {
                if (result[i] != initial[i]) {
                    return;
                }
            }

            min = Math.min(min, m - size);
            return;
        }

        for (int i = idx; i < points.size(); i++) {
            int[] point = points.get(i);
            map[point[0]][point[1]] = 0;
            map[point[0] + 1][point[1]] = 0;
            btk(size, count + 1, i + 1);
            map[point[0]][point[1]] = point[0] + 1;
            map[point[0] + 1][point[1]] = point[0];
        }
    }


    private static int[] reach() {
        int[] answer = new int[12];

        for (int i = 1; i < 12; i++) {
            int x = i;

            for (int j = 1; j < 16; j++) {
                if (map[x][j] != 0) {
                    x = map[x][j];
                }
            }

            answer[x] = i;
        }

        return answer;
    }
}
