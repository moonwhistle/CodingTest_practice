


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String str = input.next();

        int[] arr= new int[str.length()];

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = str.charAt(i)-'0'; //문자 '0'이 48번임
        }

        for(int i=0;i<arr.length-1;i++)
        {
            int tmp =0;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]<arr[j])
                {
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;


                }
            }
        }

        for(int v: arr)
        {
            System.out.print(v+"");
        }





    }
}

