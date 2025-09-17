import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        Queue<Integer> cards = new LinkedList<>();
        for(int i = 0; i<N; i++) {
            cards.add(i + 1);
        }
        
        while(cards.size() != 1) {
            cards.poll(); // 위에 버리고
            
            int num = cards.poll();
            cards.add(num);
        }

        System.out.println(cards.peek());
    }
}
