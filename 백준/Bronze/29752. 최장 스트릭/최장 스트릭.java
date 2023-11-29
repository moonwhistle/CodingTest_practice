import java.util.*;



public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];

        int cnt =0;
        int answer = 0;
        for(int i=0;i<N;i++)
        {
            int a = input.nextInt();
            arr[i] = a;

            if(a == 0)
            {

                cnt =0;
                continue;
            }

            cnt ++;
            if(cnt> answer)
            {
                answer = cnt;
            }

        }

        System.out.println(answer);


    }


}

