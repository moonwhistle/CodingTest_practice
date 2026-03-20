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
    static List<int[]> stones;
    static int max;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        starts = new ArrayList<>();
        max = Integer.MIN_VALUE;
        stones = new ArrayList<>();

        for(int y = 0 ; y < N ; y++) {
            st = new StringTokenizer(br.readLine());

            for(int x = 0 ; x < N ; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());

                if(map[y][x] == 1) {
                    stones.add(new int[]{y, x});
                }
            }
        }

        for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            starts.add(new int[]{y - 1, x - 1});
        }

        // do
        removeStone(0, 0);
        System.out.println(max + starts.size());
    }

    private static void removeStone(int count, int idx) {
        if(count == M) {
            bfs();
            return;
        }

        for(int i = idx; i < stones.size(); i++) {
            int[] p = stones.get(i);
            int y = p[0];
            int x = p[1];
            map[y][x] = 0;
            removeStone(count + 1, i + 1);
            map[y][x] = 1;
        }
    }

    private static void bfs() {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];

        for(int[] start : starts) {
            queue.add(start);
            visited[start[0]][start[1]] = true;
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];

            for(int i = 0 ; i < 4 ; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >=0 && nx >=0 && ny < N && nx < N && !visited[ny][nx] && map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    count++;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        max = Math.max(max, count);
    }

}
