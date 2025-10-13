import java.util.Map;
import java.util.Scanner;

public class Solution {

    static int maxScore;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            int ingredient = input.nextInt();
            int maxCalorie = input.nextInt();
            maxScore = 0;
            Food[] foods = new Food[ingredient];
            boolean[] visited = new boolean[ingredient];

            for (int j = 0; j < ingredient; j++) {
                int score = input.nextInt();
                int calorie = input.nextInt();
                foods[j] = new Food(score, calorie);
            }

            btk(foods, maxCalorie, 0, 0, visited, 0);

            System.out.println("#" + i + " " + maxScore);
        }
    }

    private static void btk(Food[] foods, int maxCalorie, int calorie, int score, boolean[] visited, int start) {
        if (calorie > maxCalorie) {
            return;
        }

        maxScore = Math.max(score, maxScore);

        for (int i = start; i < foods.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                calorie += foods[i].calorie();
                score += foods[i].score();
                btk(foods, maxCalorie, calorie, score, visited, i);
                visited[i] = false;
                calorie -= foods[i].calorie();
                score -= foods[i].score();
            }
        }
    }
}

class Food {

    private final int score;
    private final int calorie;

    public Food(int score, int calorie) {
        this.score = score;
        this.calorie = calorie;
    }

    public int score() {
        return score;
    }

    public int calorie() {
        return calorie;
    }
}
