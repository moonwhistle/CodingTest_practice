import javax.crypto.spec.PSource;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int[] arr= new int[N];

        int num = 1;
        for(int i=0;i<N;i++)
        {
            arr[i] = num;
            num++;
        }

        int cnt =0;

        for(int i=0;i<N;i++)
        {
            int sum = 0;

            for(int j=i;j<N;j++)
            {

                sum+=arr[j];
                
                if(sum>N)
                {
                    break;
                }

                if(sum == N)
                {
                    cnt++;
                    break;
                }



            }
        }

        System.out.println(cnt);

    }
}