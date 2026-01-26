import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static Scanner input = new Scanner(System.in);
    static char[][] map;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        int N = input.nextInt();
        int M = input.nextInt();
        setMap(N, M);

        for(int y = 0 ; y <= N - 8; y++) {
            for(int x = 0 ; x <= M - 8; x++) {
                char delimiter = map[y][x];
                int remain = (y + x) % 2;
                int cnt = 0;
                            
                for(int yy = y; yy < y + 8; yy++) {
                    for(int xx = x; xx < x + 8; xx++) {
                        boolean isTrue = false;
                        
                        if((yy + xx) % 2 == remain && map[yy][xx] == delimiter) {
                            isTrue = true;
                        } else if ((yy + xx) % 2 != remain && map[yy][xx] == other(delimiter) ){
                            isTrue = true;
                        }

                        if(!isTrue) {
                            cnt++;
                        }
                    }
                }

                cnt = Math.min(cnt, 64 - cnt);
                min = Math.min(min, cnt);
            }
        }

        System.out.println(min);
    }

    private static char other(char delimiter) {
        if(delimiter == 'B') {
            return 'W';
        }

        return 'B';
    }

    private static void setMap(int N, int M) {
        map = new char[N][M];

        for(int y = 0 ; y < N ; y++) {
            String line = input.next();
            int x = 0;

            for(char lineElement : line.toCharArray()) {
                map[y][x] = lineElement;
                x++;
            }
        }
    }
}