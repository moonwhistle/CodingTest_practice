import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static char[][] map;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            answer = 0;

            for (int y = 0; y < N; y++) {
                String line = br.readLine();

                for (int x = 0; x < N; x++) {
                    map[y][x] = line.charAt(x);
                }
            }

            click();

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void click() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int bomb = getBombCount(y, x);

                if (bomb == 0 && map[y][x] == '.') {
                    answer++;
                    bfs(y, x);
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == '.') {
                    answer++;
                }
            }
        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        map[y][x] = '0';

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int ny = now[0];
            int nx = now[1];

            for (int i = 0; i < 8; i++) {
                int yy = ny + dy[i];
                int xx = nx + dx[i];

                if (canNotMove(yy, xx) || Character.isDigit(map[yy][xx]) || map[yy][xx] == '*') {
                    continue;
                }

                int bomb = getBombCount(yy, xx);

                if (bomb == 0) {
                    map[yy][xx] = '0';
                    queue.add(new int[]{yy, xx});
                } else {
                    map[yy][xx] = (char) (bomb + '0');
                }
            }
        }
    }

    private static int getBombCount(int y, int x) {
        int cnt = 0;
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (canNotMove(ny, nx)) {
                continue;
            }

            if (map[ny][nx] == '*') {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean canNotMove(int y, int x) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}
