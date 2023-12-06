import java.util.*;



public class Main {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[][] arr = new char[5][15];
        int max = 0;
        for(int i=0;i<5;i++)
        {
            String S = input.nextLine();
            int le = S.length();
            if(max<S.length())
            {
                max = S.length();
            }
            for(int j=0;j<le;j++)
            {
                arr[i][j] = S.charAt(j);
            }
        }
        for(int i=0;i<max;i++)
        {
            for(int j =0;j< 5;j++)
            {
                if(arr[j][i]=='\0')
                {
                    continue;
                }
                System.out.print(arr[j][i]);
            }
        }


    }

}

