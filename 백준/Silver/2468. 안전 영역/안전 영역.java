import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        map = new int[N][N];
        int max = 0;

        // map 설정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int number = input.nextInt();
                max = Math.max(max, number);
                map[i][j] = number;
            }
        }

        int count = 0; //잠기지 않는 영역의 최대 개수

        for (int i = 0; i <= max; i++) {
            visited = new boolean[N][N]; // visited 초기화
            int safe = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && map[x][y] > i) {
                        safe++;
                        dfs(x, y, i, N);
                    }
                }
            }
            count = Math.max(count, safe);
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y, int rain, int N) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                if (map[newX][newY] > rain && !visited[newX][newY]) {
                    dfs(newX, newY, rain, N);
                }
            }
        }
    }
}
