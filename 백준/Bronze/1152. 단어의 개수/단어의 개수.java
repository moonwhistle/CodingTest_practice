import java.util.*;
import java.util.regex.Pattern;


public class Main {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String S = input.nextLine();

        S = S.strip();
        String[] Sarr = S.split(" ");

        int cnt = 0;

        if(S.length()==0)
        {
            System.out.println(0);
        }
        else
        {
            for(String v: Sarr)
            {
                if(Pattern.matches("^[a-zA-Z]*$", v))
                {
                    cnt +=1;
                }
            }

            System.out.println(cnt);
        }









    }

}

