import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int mask;
    static int count;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T; t++) {
            int multi = 1;
            N = Integer.parseInt(br.readLine());
            mask = 0;
            count = 0;

            while(true) {
                int num = multi * N;
                String s = String.valueOf(num);

                for(char sE : s.toCharArray()) {
                    mask |= (1 << (sE - '0'));
                }

                count++;
                multi++;

                if(mask == (1 << 10) - 1) {
                    System.out.println("#" + t + " " + num);
                    break;
                }
            }
        }
    }
}
