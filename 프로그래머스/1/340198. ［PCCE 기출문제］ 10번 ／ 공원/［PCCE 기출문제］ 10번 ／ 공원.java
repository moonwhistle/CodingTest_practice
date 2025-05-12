import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {
    
    static List<Integer> matPossible = new ArrayList<>();
    
    public static int solution(int[] mats, String[][] park) {
        int answer = 0;

        //park 요소 접근하기
        for (int y = 0; y < park.length; y++) {
            for (int x = 0; x < park[y].length; x++) {
                if (Objects.equals(park[y][x], "-1")) {
                    findMatPlace(y, x , mats, park);
                }
            }
        }

        Collections.sort(matPossible);

        if(matPossible.isEmpty()) {
            System.out.println(0);
            return -1;
        }
        answer = matPossible.get(matPossible.size() - 1);
        System.out.println(answer);
        return answer;
    }

    private static void findMatPlace(int y, int x, int[] mats, String[][] park) {
        for (int mat : mats) {
            boolean isPossible = true;

            if (y + mat > park.length || x + mat > park[0].length) {
                continue;
            }

            for (int startY = y; startY < y + mat ; startY++) {
                for (int startX = x; startX < x + mat; startX++) {
                    if (!park[startY][startX].equals("-1")) {
                        isPossible = false;
                        break;
                    }
                }
                if (!isPossible) {
                    break;
                }
            }


            if (isPossible && !matPossible.contains(mat)) {
                matPossible.add(mat);
            }
        }
    }
}