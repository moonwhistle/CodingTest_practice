import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> starts;
    static int max;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        starts = new ArrayList<>();
        max = Integer.MIN_VALUE;
        
        for(int y = 0 ; y < N ; y++) {
            st = new StringTokenizer(br.readLine());

            for(int x = 0 ; x < N ; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            starts.add(new int[]{y - 1, x - 1});
        }

        // do
        for(int[] start : starts) {
            int y = start[0];
            int x = start[1];
            visited[y][x] = true;
            btk(y, x, 0, 0);
            visited[y][x] = false;
        }

        System.out.println(max);
    }

    private static void btk(int y, int x, int removeCnt, int moveCnt) {
        if(map[y][x] == 1 && removeCnt >= M) {
            max = Math.max(max, moveCnt);
            return;
        }

        if(map[y][x] == 1) {
            removeCnt++;
        }

        for(int i = 0 ; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && nx >=0 && ny < N && nx < N && !visited[ny][nx]) {
                visited[ny][nx] = true;
                btk(ny, nx, removeCnt, moveCnt + 1);
                visited[ny][nx] = false;
            }
        }
    }
}