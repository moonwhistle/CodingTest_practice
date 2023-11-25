import java.lang.reflect.Array;
import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int N = input.nextInt();
       int []arr = new int[N];
       for(int i=0;i<N;i++)
       {
           arr[i] = i+1;
       }
       int M = input.nextInt();

       for(int i=0;i<M;i++)
       {
           int left = input.nextInt();
           int right = input.nextInt();
           Stack<Integer> stk = new Stack<>();

           for(int j = left-1; j < right;j++)
           {
               stk.add(arr[j]);
           }

           for(int k=0;k<N;k++)
           {
               if(k>=left-1 && k<right)
               {
                   arr[k] = stk.pop();

               }
               else
               {
                   arr[k] = arr[k];
               }

           }




       }

        for (int a: arr)
        {
            System.out.print(a+ " ");

        }
        System.out.println("\n");




    }


}

