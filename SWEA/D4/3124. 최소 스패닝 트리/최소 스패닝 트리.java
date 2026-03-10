import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] node;
    static long count;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            count = 0;
            node = new int[N+1];
            pq = new PriorityQueue<>();
            makeSet();

            for(int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                pq.offer(new Node(s, e, w));
            }

            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(union(now.s, now.e)) {
                    count += now.w;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }

    private static boolean union(int a, int b) {
        int aR = find(a);
        int bR = find(b);

        if(aR == bR) {
            return false;
        }

        node[bR] = aR;
        return true;
    }

    private static int find(int a) {
        if(a != node[a]) {
            node[a] = find(node[a]);
        }

        return node[a];
    }

    private static void makeSet() {
        for(int i = 1 ; i <= N ; i++) {
            node[i] = i;
        }
    }
}

class Node implements Comparable<Node> {

    int s;
    int e;
    int w;

    public Node(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.w, other.w);
    }
}
