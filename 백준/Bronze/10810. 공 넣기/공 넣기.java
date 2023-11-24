

import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       int N = input.nextInt();
       int M = input.nextInt();

       int[] basket = new int[N];

       for(int i=0;i<M;i++)
       {
           int one = input.nextInt();
           int two = input.nextInt();
           int ball = input.nextInt();
           for(int j=one-1;j<two;j++)
           {
               basket[j] = ball;
           }
       }

       for(int i=0;i<N;i++)
       {
           if(basket[i] != 0)
           {
               System.out.println(basket[i]);
           }
           else
           {
               System.out.println(0);
           }
       }

    }


}

