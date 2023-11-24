

import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

      int N = input.nextInt();

      List<Integer> list = new ArrayList();

      for(int i=0; i<N;i++)
      {
          list.add(input.nextInt());
      }

      int max = Collections.max(list);
      int min = Collections.min(list);

        System.out.println(min+" "+max);

    }


}

