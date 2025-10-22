import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Map<String, Point> colors = setColorsPoint();

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            String first = input.next();
            String second = input.next();

            Point firstPoint = colors.get(first);
            Point secondPoint = colors.get(second);

            int y = Math.abs(firstPoint.y - secondPoint.y);
            int x = Math.abs(firstPoint.x - secondPoint.x);

            if ((Objects.equals(first, "blue") && Objects.equals(second, "orange")) || (Objects.equals(second, "blue")
                    && Objects.equals(first, "orange"))) {
                System.out.println("C");
            } else if (x + y == 1) {
                System.out.println("A");
            } else if (x + y == 3) {
                System.out.println("C");
            } else if (x + y == 0) {
                System.out.println("E");
            } else {
                System.out.println("X");
            }
        }
    }

    private static Map<String, Point> setColorsPoint() {
        Map<String, Point> map = new HashMap<>();
        
        map.put("purple", new Point(0, 0));
        map.put("blue", new Point(1, 0));
        map.put("green", new Point(2, 0));
        map.put("red", new Point(0, 1));
        map.put("orange", new Point(1, 1));
        map.put("yellow", new Point(2, 1));
        
        return map;
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
