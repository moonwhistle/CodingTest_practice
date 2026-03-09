import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int m;
    static int[] nodes;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T ; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            nodes = new int[n + 1];
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            for(int i = 0 ; i <= n; i++) {
                nodes[i] = i;
            }

            for(int i = 0 ; i<m ; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(cmd == 0) {
                    union(a,b);
                } else {
                    int aR = findSet(a);
                    int bR = findSet(b);

                    if(aR == bR) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }

            System.out.println(sb.toString());
        }
    }

    private static void union(int a, int b) {
        int aR = findSet(a);
        int bR = findSet(b);

        nodes[bR] = aR;
    }

    private static int findSet(int a) {
        if(a != nodes[a]) {
            nodes[a] = findSet(nodes[a]); // path compression
        }

        return nodes[a];
    }
}