import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int T = 1; T < 11; T++) {
            // setting
            int caseNumber = input.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                queue.add(input.nextInt());
            }

            // while 문으로 맨 앞 넘버가 0 이하인지 확인하며 돌리기
            int backNum = queue.peek();
            int minus = 0;

            while (backNum > 0) {
                minus = (minus % 5) + 1;
                backNum = queue.poll() - minus;

                queue.add(Math.max(backNum, 0));
            }

            System.out.print("#" + caseNumber + " ");
            for (int i : queue) {
                System.out.print(i + " ");
            }
            System.out.println(System.lineSeparator());
        }
    }
}
