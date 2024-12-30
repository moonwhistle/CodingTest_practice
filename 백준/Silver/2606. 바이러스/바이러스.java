import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    private static List<List<Integer>> s;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int computer = input.nextInt();
        int connection = input.nextInt();

        s = new ArrayList<>();
        visited = new boolean[computer+1];

        for (int i = 0; i < computer + 1; i++) {
            s.add(new ArrayList<>());
        }

        for (int i = 0; i < connection; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            s.get(start).add(end);
            s.get(end).add(start);
        }
        count = 0;
        visited[1] = true;

        for(int i =1 ; i<computer+1; i++) {
            if(visited[i]){
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int i) {
        if(visited[i]) {
            for(int num : s.get(i)){
                if(!visited[num]) {
                    visited[num] = true;
                    count++;
                    DFS(num);
                }
            }
        }
    }
}
