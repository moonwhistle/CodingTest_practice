import java.util.Scanner;

public class Main {

    static int[][] map; // 기본 map
    static int[][] sumMap; // 행 누적합 map

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt(); // 표의 크기
        map = new int[N + 1][N + 1]; // n+1 배열
        sumMap = new int[N + 1][N + 1];

        int M = input.nextInt(); // 합 횟수
        makeMap(input);
        makeSumMap();

        for (int i = 0; i < M; i++) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            int sum = addNumber(x1, y1, x2, y2);
            System.out.println(sum);
        }
    }

    private static int addNumber(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i < x2 + 1; i++) {
            sum += sumMap[i][y2] - sumMap[i][y1 - 1];
        }
        return sum;
    }

    private static void makeSumMap() {
        for (int i = 1; i < sumMap.length; i++) {
            for (int j = 1; j < sumMap[i].length; j++) {
                sumMap[i][j] = sumMap[i][j - 1] + map[i][j];
            }
        }
    }

    private static void makeMap(Scanner input) { // 지도에 값 채워넣기
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = input.nextInt();
            }
        }
    }
}
