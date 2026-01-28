import java.util.Scanner;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int target = input.nextInt();
        int[][] map = new int[N][N];

        int num = 2;
        int count = 0;
        int length = 1;
        int x = N / 2;
        int y = N / 2;
        map[y][x] = 1;
        int direct = 0;
        int targetY = 0;
        int targetX = 0;

        while (num <= N * N) {
            if (count == 2) {
                length++;
                count = 0;
            }

            for (int i = 0; i < length; i++) {
                y += dy[direct];
                x += dx[direct];

                if (y < 0 || x < 0 || y >= N || x >= N) {
                    break;
                }

                if (num == target) {
                    targetY = y;
                    targetX = x;
                }

                map[y][x] = num;
                num++;
            }

            direct = (direct + 1) % 4;
            count++;
        }

        for (int[] line : map) {
            for (int lineElement : line) {
                System.out.print(lineElement + " ");
            }
            System.out.println();
        }

        if (target == 1) {
            System.out.println((N / 2) + 1 + " " + ((N / 2) + 1));
        } else {
            System.out.println((targetY + 1) + " " + (targetX + 1));
        }
    }
}
