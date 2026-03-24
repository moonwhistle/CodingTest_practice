import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int H;
    static int M;

    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static List<int[]> person;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        result = new int[N][N];
        person = new ArrayList<>();

        for(int y = 0; y < N ;y++) {
            st = new StringTokenizer(br.readLine());

            for(int x = 0 ; x < N ; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                if(map[y][x] == 2) {
                    person.add(new int[]{y, x});
                }
            }
        }

        for(int[] p : person) {
            bfs(p);
        }

        for(int y = 0 ;y < N ;y++) {
            for(int x = 0 ; x < N ; x++) {
                System.out.print(result[y][x] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int[] p) {
        visited = new boolean[N][N];
        visited[p[0]][p[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{p[0], p[1], 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int c = now[2];

            if(map[y][x] == 3) {
                result[p[0]][p[1]] = c;
                return;
            }

            for(int i = 0 ; i < 4; i++) {
                int ny = dy[i] + y;
                int nx = dx[i] + x;

                if(ny >= 0 && nx >=0 && ny < N && nx < N && !visited[ny][nx]) {
                    if(map[ny][nx] != 1) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx, c + 1});
                    }
                }
            }
        }

        result[p[0]][p[1]] = -1;
    }
}