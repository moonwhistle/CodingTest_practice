import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    private static boolean[] visited;
    private static List<List<Integer>> ss;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        visited = new boolean[N+1];

        ss = new ArrayList<>();

        for(int i = 0 ; i<N+1; i++) {
            ss.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            ss.get(start).add(end);
            ss.get(end).add(start);
        }

        int count = 0;

        for(int i = 1 ; i<N+1; i++){
            if(!visited[i]) {
                count ++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS(int i) {
        if(visited[i]){
            return;
        }
        visited[i] = true;
        for(int num : ss.get(i)) {
            if(!visited[num]) {
                DFS(num);
            }
        }
    }
}
