import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       int N = input.nextInt();
       String S = input.next();

       List<Integer> list = new ArrayList<>();
       for(int j =0;j<N;j++)
       {
           char tmp = S.charAt(j);
           int n = tmp-'0';
           list.add(n);
       }
       int sum = list.stream().mapToInt(Integer::intValue).sum();
       System.out.println(sum);





    }


}

