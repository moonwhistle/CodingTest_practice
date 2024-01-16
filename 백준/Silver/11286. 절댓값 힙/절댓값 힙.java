

import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();


        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(); //양수 담음
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder()); //음수 담음



        for(int i=0;i<N;i++)
        {
           int num = input.nextInt();



           if(num == 0)
           {
               if(priorityQueue1.peek() == null && priorityQueue2.peek()==null)
               {
                   System.out.println(0);
               } else if (priorityQueue1.peek() != null && priorityQueue2.peek() == null) {
                   System.out.println(priorityQueue1.poll());
               } else if (priorityQueue2.peek() != null && priorityQueue1.peek() == null) {
                   System.out.println(priorityQueue2.poll());
               } else if (priorityQueue1.peek() == abs(priorityQueue2.peek())) {
                   System.out.println(priorityQueue2.poll());
               } else if (priorityQueue1.peek()>abs(priorityQueue2.peek())) {
                   System.out.println(priorityQueue2.poll());
               }
               else {
                   System.out.println(priorityQueue1.poll());
               }

           }

           if(num <0)
           {
               priorityQueue2.add(num);
           }

           if(num>0)
           {
               priorityQueue1.add(num);
           }

        }



    }
}

