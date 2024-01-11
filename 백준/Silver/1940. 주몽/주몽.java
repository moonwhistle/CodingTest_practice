import javax.crypto.spec.PSource;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        int[] mat = new int[N];

        for(int i=0;i<N;i++)
        {
            mat[i] = input.nextInt();
        }

        int cnt = 0;

        for(int i=0;i<N-1;i++)
        {
            int sum = mat[i]; //기준

            for(int j=i+1;j<N;j++)
            {
                sum += mat[j];
                
                if(sum == M)
                {
                    cnt++;
                }
                sum -= mat[j];
            }
        }

        System.out.println(cnt);




    }
}