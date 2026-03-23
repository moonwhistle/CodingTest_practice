import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;
    static int U;
    static int D;
    static int[][] map;
    static int[][] clone;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        max = Integer.MIN_VALUE;

        for(int y = 0 ; y < N ; y++) {
            st = new StringTokenizer(br.readLine());

            for(int x = 0 ; x < N ; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        btk(0, new ArrayList<>(), 0);
        System.out.println(max);
    }

    private static void btk(int count, List<int[]> box, int idx) {
        if(count == K) {
            cloneMap();
            bfs(box);
            return;
        }

        for(int i = idx; i < N * N; i++) {
            int y = i / N;
            int x = i % N;
            box.add(new int[]{y, x});
            btk(count + 1, box, i + 1);
            box.remove(box.size() - 1);
        }
    }

    private static void bfs(List<int[]> box) {
        int count = box.size();

        Queue<int[]> queue = new LinkedList<>();
        for(int[] n : box) {
            int y = n[0];
            int x = n[1];
            visited[y][x] = true;
            queue.add(n);
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];

            for(int i = 0 ; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= 0 && nx >=0 && ny < N && nx < N && !visited[ny][nx]) {
                    int f = map[y][x];
                    int s = map[ny][nx];

                    if(Math.abs(f - s) >= U && Math.abs(f - s) <= D) {
                        visited[ny][nx] = true;
                        count++;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }

        max = Math.max(max, count);
    }

    private static void cloneMap() {
        clone = new int[N][N];
        visited = new boolean[N][N];

        for(int y = 0 ; y < N ;y++) {
            for(int x = 0 ;x <N; x++) {
                clone[y][x] = map[y][x];
            }
        }
    }
}