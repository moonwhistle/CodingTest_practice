import java.lang.reflect.Array;
import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       int N = input.nextInt();

       List<Double> list = new ArrayList<>();

       for(int i=0;i<N;i++)
       {
           list.add(input.nextDouble());
       }

       double M = Collections.max(list);

       List<Double> list1 = new ArrayList<>();
      for(double v: list)
      {
          v = v/M*100;
          list1.add(v);

      }

      double sum = list1.stream().mapToDouble(Double::valueOf).sum();

      double aver = sum/list1.size();

        System.out.println(aver);



    }


}

