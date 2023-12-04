import java.util.*;
import java.util.regex.Pattern;


public class Main {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String S = input.next();
        int time =0;
        String[] arr = S.split("");
        for(String v : arr)
        {

            if(v.equals("A") || v.equals("B") ||v.equals("C") )
            {
                time += 3;
            }
            else if(v.equals("D") || v.equals("E") ||v.equals("F") )
            {
                time += 4;
            }
            else if(v.equals("G") || v.equals("H") ||v.equals("I") )
            {
                time += 5;
            }
            else if(v.equals("J") || v.equals("K") ||v.equals("L") )
            {
                time += 6;
            }
            else if(v.equals("M") || v.equals("N") ||v.equals("O") )
            {
                time += 7;
            }
            else if(v.equals("P") || v.equals("Q") ||v.equals("R")||v.equals("S"))
            {
                time += 8;
            }
            else if(v.equals("T") || v.equals("U") ||v.equals("V") )
            {
                time += 9;
            }
            else 
            {
                time += 10;

            }
        }
        System.out.println(time);




    }

}

