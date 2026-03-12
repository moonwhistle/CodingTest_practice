import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int N;
    static int W;
    static int H;
    static int brickCount;
    static int[][] clone;
    static int min;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            clone = new int[H][W];
            brickCount = 0;
            min = Integer.MAX_VALUE;

            for(int y = 0 ; y < H ;y ++) {
                st = new StringTokenizer(br.readLine());

                for(int x = 0 ; x <W ; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());

                    if(map[y][x] != 0) {
                        brickCount++;
                    }
                }
            }

            btk(new ArrayList<>());
            System.out.println("#" + t + " " + min);
        }
    }

    private static void btk(List<Integer> box) {
        if(box.size() == N) {
            cloneMap();
            crash(box);
            return;
        }

        for(int i = 0 ; i < W; i++) {
            box.add(i);
            btk(box);
            box.remove(box.size() - 1);
        }
    }

    private static void crash(List<Integer> box) {
        int count = 0;

        for(int i = 0 ; i< box.size(); i++) {
            int x = box.get(i);
            int y = findY(x);

            if(y == -1) {
                continue;
            }

            count += bfs(y, x);
            gravity();
        }

        min = Math.min(min, brickCount - count);
    }

    private static void gravity() {
        for(int x = 0 ; x < W; x++) {
            int writeY = H - 1;

            for (int y = H - 1; y >= 0; y--) {
                if (clone[y][x] != 0) {
                    int brick = clone[y][x];
                    clone[y][x] = 0;
                    clone[writeY][x] = brick;
                    writeY--;
                }
            }
        }
    }

    private static int bfs(int Y, int X) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int ww = clone[Y][X];
        clone[Y][X] = 0;
        queue.add(new int[]{Y, X ,ww});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int w = now[2] - 1;
            count++;
            int ii = 1;

            while(ii <= w) {
                for(int i = 0 ; i < 4; i++) {
                    int ny = y + (dy[i] * ii);
                    int nx = x + (dx[i] * ii);

                    if(ny < 0 || nx < 0 || ny >= H || nx >= W) {
                        continue;
                    }

                    if(clone[ny][nx] == 0) {
                        continue;
                    }

                    queue.add(new int[]{ny, nx, clone[ny][nx]});
                    clone[ny][nx] = 0;
                }

                ii++;
            }
        }

        return count;
    }

    private static int findY(int x) {
        for(int y = 0 ;y < H; y ++ ) {
            if(clone[y][x] != 0) {
                return y;
            }
        }

        return -1;
    }

    private static void cloneMap() {
        for(int y = 0 ;y < H; y++) {
            clone[y] = Arrays.copyOf(map[y], map[y].length);
        }
    }
}