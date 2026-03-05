import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Integer> box;
    
    public static void main(String[] args) {
        // Please write your code here.
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        box = new ArrayList<>();
        btk(1);
    }

    private static void btk(int idx) {
        if(box.size() == M) {
            for(int i = 0 ; i < box.size(); i++) {
                System.out.print(box.get(i) + " ");
            }
            System.out.println();

            return;
        }

        for(int i = idx; i <= N ; i++) {
            box.add(i);
            btk(i + 1);
            box.remove(box.size() - 1);
        }
    }
}