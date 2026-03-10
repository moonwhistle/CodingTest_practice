import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int sx;
    static int sy;
    static int lx;
    static int ly;
    static List<int[]> list;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            min = Integer.MAX_VALUE;
            visited = new boolean[N];

            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            lx = Integer.parseInt(st.nextToken());
            ly = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new int[]{y, x});
            }

            btk(0, 0, sx, sy);
            System.out.println("#" + t + " " + min);
        }
    }

    private static void btk(int depth, int sum, int px, int py) {
        if (depth == list.size()) {
            sum += dist(px, py, lx, ly);
            min = Math.min(min, sum);
            return;
        }

        if (sum >= min) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            int y = now[0];
            int x = now[1];

            if (!visited[i]) {
                visited[i] = true;
                btk(depth + 1, sum + dist(x, y, px, py), x, y);
                visited[i] = false;
            }
        }
    }

    private static int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
