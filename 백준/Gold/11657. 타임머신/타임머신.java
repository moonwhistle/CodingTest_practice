import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final int MAX_VALUE = Integer.MAX_VALUE;

    static long[] min;
    static ArrayList[] edge;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        min = new long[N + 1];
        edge = new ArrayList[M + 1];

        //그래프 세팅
        for (int i = 1; i < M + 1; i++) {
            edge[i] = new ArrayList<Integer>();
            int A = input.nextInt();
            int B = input.nextInt();
            int C = input.nextInt();
            edge[i].add(A);
            edge[i].add(B);
            edge[i].add(C);
        }
        //가중치 세팅
        min[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            min[i] = MAX_VALUE;
        }

        //밸만-포드 알고리즘
        for (int i = 0; i < N - 1; i++) {
            for (int k = 1; k < M + 1; k++) {
                int weight = (int) edge[k].get(2);
                int start = (int) edge[k].get(0);
                int end = (int) edge[k].get(1);
                if (min[start] != MAX_VALUE && min[end] > min[start] + weight) {
                    min[end] = min[start] + weight;
                }
            }
        }

        if (findNoCycle(M)) {
            for (int i = 2; i < N + 1; i++) {
                if (min[i] == MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(min[i]);
                }
            }
        } else {
            System.out.println(-1);
        }
    }

    //음수 사이클 찾는 알고리즘
    private static boolean findNoCycle(int M) {
        for (int i = 1; i < M + 1; i++) {
            int weight = (int) edge[i].get(2);
            int start = (int) edge[i].get(0);
            int end = (int) edge[i].get(1);
            if (min[start] != MAX_VALUE && min[end] > min[start] + weight) {
                return false;
            }
        }
        return true;
    }
}
