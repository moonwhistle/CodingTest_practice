import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] city;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new int[N + 1];
        makeSet();

        for(int i = 1 ; i<= N ;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1 ; j <= N ;j++) {
                int a = Integer.parseInt(st.nextToken());

                if(a == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int root = -1;
        boolean isPossible = true;

        for(int i = 0 ; i < M ; i++) {
            int a = Integer.parseInt(st.nextToken());

            if(root == -1) {
                root = find(a);
                continue;
            }

            if(find(a) != root) {
                isPossible = false;
                break;
            }
        }

        if(isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int a, int b) {
        int aR = find(a);
        int bR = find(b);
        city[bR] = aR;
    }

    private static int find(int a) {
        if(city[a] != a) {
            city[a] = find(city[a]);
        }

        return city[a];
    }

    private static void makeSet() {
        for(int i = 1 ; i <= N ; i++) {
            city[i] = i;
        }
    }
}
