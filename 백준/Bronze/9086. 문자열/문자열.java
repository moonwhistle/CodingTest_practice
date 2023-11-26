import java.util.*;



public class Main {


    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       int T = input.nextInt();

       for(int i=0;i<T;i++)
        {
            String S = input.next();
            char SS = S.charAt(0);
            char SL = S.charAt(S.length()-1);
            System.out.println(SS+""+SL);
        }




    }


}

