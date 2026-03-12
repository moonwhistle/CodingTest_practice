import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int mask = 0;
            
            for(int i = 0 ; i < N ; i++) {
                mask |= (1 << i);
            }

            M &= mask;

            if(mask == M) {
                System.out.println("#" + t + " " + "ON");
            } else {
                System.out.println("#" + t + " " + "OFF");
            }
        }
    }
}