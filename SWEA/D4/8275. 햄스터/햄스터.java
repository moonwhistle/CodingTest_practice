import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int X;
    static int M;

    static int[] box;
    static int[][] doc;
    static int[] answer;
    static int max;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            box = new int[N + 1];
            doc = new int[M][3];
            answer = new int[N + 1];
            max = -1;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                doc[i] = new int[]{s, e, c};
            }

            btk(1, 0);

            if (max == -1) {
                System.out.println("#" + t + " " + -1);
            } else {
                System.out.print("#" + t + " ");
                print();
                System.out.println();
            }
        }
    }

    private static void print() {
        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static void btk(int idx, int sum) {
        if (idx > N) {
            if(isSatisfied() && sum > max) {
                max = sum;
                answer = Arrays.copyOf(box, box.length);
            }

            return;
        }

        for (int x = 0; x <= X; x++) {
            box[idx] = x;
            btk(idx + 1, sum + x);
            box[idx] = 0;
        }
    }

    private static boolean isSatisfied() {
        for (int[] element : doc) {
            int sum = 0;
            int s = element[0];
            int e = element[1];
            int c = element[2];

            for (int i = s; i < e + 1; i++) {
                sum += box[i];
            }

            if (sum != c) {
                return false;
            }
        }

        return true;
    }
}
