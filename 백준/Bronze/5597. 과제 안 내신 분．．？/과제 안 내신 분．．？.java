

import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       HashSet<Integer> arr1 = new HashSet<>();
       for(int i=0;i<30;i++)
       {
           arr1.add(i+1);
       }
       HashSet<Integer> arr2 = new HashSet<>();
       for(int i=0;i<28;i++)
       {
           arr2.add(input.nextInt());
       }
       arr1.removeAll(arr2);
       for(int i:arr1)
       {
           System.out.println(i);
       }
    }


}

