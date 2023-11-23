import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] list = new int[N];
        for(int i=0;i<N;i++)
        {
            int a = input.nextInt();
            list[i] = a;

        }
        int v = input.nextInt();
        int cnt =0;
        for(int i=0;i<N;i++)
        {
            if(v == list[i])
            {
                cnt++;
            }

        }
        System.out.println(cnt);

    }


}

