import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] people;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            people = new int[n + 1];
            set = new HashSet<>();

            for (int i = 0; i < n + 1; i++) {
                people[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            for (int i = 1; i < n + 1; i++) {
                set.add(findSet(i));
            }

            System.out.println("#" + t + " " + set.size());
        }
    }

    private static void union(int a, int b) {
        int aR = findSet(a);
        int bR = findSet(b);

        people[bR] = aR;
    }

    private static int findSet(int x) {
        if (x != people[x]) {
            people[x] = findSet(people[x]); // path compression
        }

        return people[x];
    }
}
