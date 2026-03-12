import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;
    static Set<String> set;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            String num = br.readLine();
            set = new HashSet<>();
            int lineCount = N / 4;
            
            for(int i = 0 ; i <= num.length() - lineCount; i++) { 
                set.add(num.substring(i, i + lineCount));
            }

            for(int i = num.length() - lineCount + 1; i < num.length(); i++) {
                StringBuilder sb = new StringBuilder();
                String a = num.substring(i);
                sb.append(a);
                int sub = lineCount - a.length();
                String b = num.substring(0, sub);
                sb.append(b);
                set.add(sb.toString());
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            for(String e : set) {
                pq.add(Integer.parseInt(e, 16));
            }

            int count = 0;

            while(true) {
                count++;
                int n = pq.poll();

                if(count == K) {
                    System.out.println("#" + t + " " + n);
                    break;
                }
            }
        }
    }
}