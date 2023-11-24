

import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

      List<Integer> list = new ArrayList<>();

      for(int i=0;i<9;i++)
      {
          list.add(input.nextInt());
      }

        System.out.println(Collections.max(list));
        System.out.println(list.indexOf(Collections.max(list))+1);



    }


}

