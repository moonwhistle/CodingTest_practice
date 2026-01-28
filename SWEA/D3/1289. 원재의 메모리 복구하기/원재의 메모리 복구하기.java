import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for(int t = 1; t <= T; t++) {
            String given = input.next();
            char initial = '0';
            int cnt = 0;

            for(char givenElement : given.toCharArray()) {
                if(givenElement != initial) {
                    cnt++;

                    if(initial == '0') {
                        initial = '1';
                    } else {
                        initial = '0';
                    }
                }
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}