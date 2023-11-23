import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int X = input.nextInt();
        int[] list = new int[N];
        for(int i=0;i<N;i++)
        {
            int a = input.nextInt();
            list[i] = a;

        }


        for(int i=0;i<N;i++)
        {
            if(X > list[i])
            {
                System.out.print(list[i]+" ");
            }

        }


    }


}

