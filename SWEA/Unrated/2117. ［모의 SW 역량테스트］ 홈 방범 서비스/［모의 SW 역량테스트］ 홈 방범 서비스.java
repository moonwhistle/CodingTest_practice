import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            max = 0;
            buildMap();

            int n = 1;
            while (n <= 31) {
                int price = n * n + (n - 1) * (n - 1);

                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        int count = checkHome(y, x, n);

                        if (count * M >= price) {
                            max = Math.max(max, count);
                        }
                    }
                }

                n++;
            }

            System.out.println("#" + t + " " + max);
        }

    }

    private static int checkHome(int y, int x, int size) {
        int count = 0;

        int xSize = x + size - 1;
        int rxSize = x - (size - 1);

        for (int i = y; i < y + size; i++) {
            for (int j = rxSize; j <= xSize; j++) {
                if (isIn(i, j) && map[i][j] == 1) {
                    count++;
                }
            }
            xSize--;
            rxSize++;
        }

        xSize = x + size - 2;  
        rxSize = x - (size - 2); 

        for (int i = y - 1; i >= y - (size - 1); i--) {
            for (int j = rxSize; j <= xSize; j++) {
                if (isIn(i, j) && map[i][j] == 1) {
                    count++;
                }
            }
            xSize--;
            rxSize++;
        }

        return count;
    }

    private static boolean isIn(int y, int x) {
        if (y >= 0 && x >= 0 && y < N && x < N) {
            return true;
        }

        return false;
    }

    private static void buildMap() throws IOException {
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }
}