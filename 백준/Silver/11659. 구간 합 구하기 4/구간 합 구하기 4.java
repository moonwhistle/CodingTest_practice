import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       int N = input.nextInt();
       int M = input.nextInt();

       int[] arr = new int[N];

       for(int i=0;i<N;i++) //수 입력
       {
           arr[i] = input.nextInt();
       }

       int[] sum = new int[N]; //arr합 담을 배열

        sum[0] = arr[0]; //첫 번째 값 지정

       int s = sum[0];

       for(int i=1;i<N;i++) //0번째 정해줬으니 1부터, 합 구해줌
       {
           s += arr[i];
           sum[i] = s;
       }

       for(int k=0;k<M;k++)
       {
           int i = input.nextInt();
           int j = input.nextInt();

           if(i==j) //같은 수 들어올 때
           {
               System.out.println(arr[j-1]); //배열값 출력
           }
           else if(i==1) //1일때 index = 0
           {
               System.out.println(sum[j-1]); //전체 합
           }
           else{ //일반적인 경우
               System.out.println(sum[j-1]-sum[i-2]);
           }




       }


    }
}