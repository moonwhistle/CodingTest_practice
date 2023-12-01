import java.util.*;



public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String S = input.next();
        char[] array  = new char[26];
        int [] array1 = new int[26];

        for(int i=0;i<26;i++)
        {
            array[i] = (char)(i+97);
        }

        for(int j=0;j<S.length();j++)
        {
            for(int k=0;k<array.length;k++)
            {
                if(S.charAt(j) == array[k])
                {
                    if(array1[k] == 0)
                    {
                        array1[k] = j+1;
                    }
                }
            }
        }

        for(int v : array1)
        {
            if(v == 0)
            {
                System.out.println(-1);
            }
            else
            {
                System.out.println(v-1);
            }
        }





    }


}

