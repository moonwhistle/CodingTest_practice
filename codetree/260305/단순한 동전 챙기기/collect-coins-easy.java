import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int min;
    static List<Integer> nums;
    static Map<Integer, int[]> map;
    static Deque<Integer> box;
    static int[] S;
    static int[] E;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        min = Integer.MAX_VALUE;
        nums = new ArrayList<>();
        map = new HashMap<>();
        box = new ArrayDeque<>();

        for (int y = 0; y < N; y++) {
            String line = sc.next();

            for(int x = 0 ;x < N ;x ++) {
                char e = line.charAt(x);

                if(Character.isDigit(e)) {
                    nums.add(e-'0');
                    map.put(e-'0', new int[]{y, x});
                }

                if(e == 'S') {
                    S = new int[]{y, x};
                }

                if(e == 'E') {
                    E = new int[]{y, x};
                }
            }
        }

        Collections.sort(nums);
        // Please write your code here.
        btk(0);

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void btk(int idx) {
        if(box.size() == 3) {
            // 계산
            cal();
            return;
        }

        for(int i = idx; i < nums.size(); i++) {
            box.offer(nums.get(i));
            btk(i + 1);
            box.removeLast();
        }
    }

    private static void cal() {
        int y = S[0];
        int x = S[1];
        int sum = 0;

        for(int b : box) {
            int[] point = map.get(b);
            int ny = Math.abs(y - point[0]);
            int nx = Math.abs(x - point[1]);

            y = point[0];
            x = point[1];

            sum += ny;
            sum += nx;
        }

        int ny = Math.abs(y - E[0]);
        int nx = Math.abs(x - E[1]);

        sum += ny;
        sum += nx;

        min = Math.min(min, sum);
    }
}