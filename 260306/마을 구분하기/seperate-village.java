import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int now;
    static List<Integer> box;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        count = 0;
        box = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // Please write your code here.

        for(int y =0 ; y < n; y++) {
            for(int x = 0 ;x < n; x++) {
                if(!visited[y][x] && grid[y][x] == 1) {
                    count++;
                    now = 0;
                    dfs(y, x);
                    box.add(now);
                }
            }
        }

        Collections.sort(box);
        System.out.println(count);
        for(int i : box) {
            System.out.println(i);
        }
    }

    private static void dfs(int y, int x) {
        if(visited[y][x]) {
            return;
        }

        now++;
        visited[y][x] = true;

        for(int i = 0 ; i< 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || grid[ny][nx] == 0) {
                continue;
            }

            dfs(ny, nx);
        }
    }
}