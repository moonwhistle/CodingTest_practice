import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//1. map 을 만든다
//2. 좌표를 이용한다
//3. 끊어지고 새로 시작하는 부분끼리 나눈다
public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static List<Integer> house = new ArrayList<>();
    //좌표 세팅
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // map 세팅
        for (int i = 0; i < N; i++) {
            String numbers = input.next();
            for (int k = 0; k < N; k++) {
                map[i][k] = numbers.charAt(k) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                //아직 방문하지 않았다면
                if (!visited[i][k] && map[i][k] == 1) {
                    count++;
                    int count = dfs(i, k, N, 0);
                    house.add(count);
                }
            }
        }

        Collections.sort(house);

        System.out.println(count);
        for(int i : house) {
            System.out.println(i);
        }
    }

    private static int dfs(int x, int y, int N, int count) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (xx >= 0 && yy >= 0 && xx < N && yy < N) {
                if (!visited[xx][yy] && map[xx][yy] == 1) {
                    count = dfs(xx, yy, N, count);
                }
            }
        }

        return count;
    }
}
