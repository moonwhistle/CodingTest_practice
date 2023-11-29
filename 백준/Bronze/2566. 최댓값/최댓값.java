import java.util.*;



public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [][] A = new int[9][9];

        int cnt =0;
        int i=1;
        int j=1;
        int ii=0;
        int jj=0;
        for(int[] v:A)
        {
            for(int s:v)
            {
                s = input.nextInt();
                if (s >= cnt)
                {

                    cnt = s;
                    ii=i;
                    jj=j;
                }
                
                j = j%9 +1;
            }
            i ++;
        }

        System.out.println(cnt);
        System.out.println(ii+" "+jj);


    }


}
