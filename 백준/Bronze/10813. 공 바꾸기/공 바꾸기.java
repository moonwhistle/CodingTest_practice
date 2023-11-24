

import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       int N = input.nextInt();
       int M = input.nextInt();

       int[] basket = new int[N];


       for(int i=0;i<N;i++)
       {
          basket[i] = i+1;
       }
       for(int i =0;i<M;i++)
       {
           int choice1 = input.nextInt();
           int choice2 = input.nextInt();

           int tmp = basket[choice1-1];
           basket[choice1-1] = basket[choice2-1];
           basket[choice2-1] = tmp;

       }
       for(int i:basket)
       {
           System.out.print(i+" ");
       }
    }


}

