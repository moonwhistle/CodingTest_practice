import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int count;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0 ,1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt(); //테스트 케이스 개수

        for(int i = 0; i< T; i++) {
            // 입력받기
            int M = input.nextInt(); //가로
            int N = input.nextInt(); //세로
            int K = input.nextInt(); //배추의 개수

            map = new int[M][N];
            visited = new boolean[M][N];
            count = 0;

            // 배추 세팅
            for(int j = 0; j<K; j++) {
                int x = input.nextInt();
                int y = input.nextInt();
                map[x][y] = 1;
            }

            // dfs
            for(int j = 0; j<M; j++) {
                for(int k = 0; k<N; k++) {
                    if(!visited[j][k] && map[j][k] == 1) {
                        count++;
                        dfs(j, k);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >=0 && newY >= 0 && newX < map.length && newY < map[0].length) {
                if(!visited[newX][newY] && map[newX][newY] == 1) {
                    dfs(newX, newY);
                }
            }
        }
    }
}
