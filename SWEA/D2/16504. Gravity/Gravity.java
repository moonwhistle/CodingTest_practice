import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for(int t = 1; t <= T; t++) {
            // 입력받기
            int N = input.nextInt();

            // setting
            int[] map = new int[N];

            for(int i = 0 ; i < N ; i++) {
                map[i] = input.nextInt();
            }

            // logic
            int max = 0;

            for(int i = 0 ; i<N -1 ; i++) {
                int cnt = 0;
                
                for(int j = i + 1; j < N; j++) {
                    if(map[i] > map[j]) {
                        cnt++;
                    }
                }

                max = Math.max(max, cnt);
            }

            System.out.println("#" + t + " " + max);
        }
    }
}