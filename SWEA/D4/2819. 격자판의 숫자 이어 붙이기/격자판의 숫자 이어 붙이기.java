import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static Set<String> set;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T; t++) {
            map = new int[4][4];
            set = new HashSet<>();

            for(int y = 0 ; y < 4 ;y ++) {
                st = new StringTokenizer(br.readLine());

                for(int x = 0 ; x < 4; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            for(int y = 0 ; y < 4 ;y ++) {
                for(int x = 0 ; x < 4; x++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(map[y][x]);
                    btk(0, sb, y, x);
                }
            }
            
            System.out.println("#" + t + " " + set.size());
        }
    }

    private static void btk(int count, StringBuilder sb, int y, int x) {
        if(count == 6 && sb.length() == 7) {
            set.add(sb.toString());
            return;
        }

        for(int i = 0 ; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4) {
                continue;
            }

            sb.append(map[ny][nx]);
            btk(count + 1, sb, ny, nx);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
