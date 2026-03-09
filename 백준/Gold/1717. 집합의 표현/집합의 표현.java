import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] nodes;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nodes = new int[n + 1];
        makeSet();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 0) {
                union(a, b);
            }

            if(cmd == 1) {
                int aR = findRoot(a);
                int bR = findRoot(b);

                if(aR == bR) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        int aR = findRoot(a);
        int bR = findRoot(b);
        nodes[bR] = aR;
    }

    private static int findRoot(int idx) {
        if (idx == nodes[idx]) {
            return idx;
        }

        return findRoot(nodes[idx]);
    }

    private static void makeSet() {
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = i;
        }
    }
}
