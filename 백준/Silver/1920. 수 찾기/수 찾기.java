import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] nList = new int[N];

        for(int i = 0; i< N; i++) {
            nList[i] = input.nextInt();
        }
        Arrays.sort(nList);

        int M = input.nextInt();
        int[] mList = new int[M];

        for(int i = 0; i< M; i++) {
            mList[i] = input.nextInt();
        }

        int[] result = new int[M];

        for(int i = 0; i< M; i++) {
            int start = 0;
            int last = nList.length - 1;
            int target = mList[i];

            while(start <= last) {
                int mid = (last + start) /2;
                int midValue = nList[mid];
                if(midValue == target) {
                    result[i] = 1;
                    break;
                }
                if(midValue > target) {
                    last = mid - 1;
                }
                if(midValue < target) {
                    start = mid + 1;
                }
            }
        }
        
        for(int num : result) {
            System.out.println(num);
        }
    }
}
