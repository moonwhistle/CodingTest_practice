import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int k;
    static int[] nums;
    static int max;
    static boolean[] isReach;
    static int[] place;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        max = Integer.MIN_VALUE;
        isReach = new boolean[k];
        place = new int[k];
        Arrays.fill(place, 1);

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.
        btk(0, 0);
        System.out.println(max);
    }

    private static void btk(int depth, int sum) {
        if(sum == k) {
            max = Math.max(max, k);
            return;
        }
        
        if(depth == n) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0 ; i < k; i++) {
            if(!isReach[i]) {
                place[i] += nums[depth];
                int newSum = sum;
                boolean isRenew = false;
                if(place[i] >= m) {
                    newSum++;
                    isReach[i] = true;
                    isRenew = true;
                }

                btk(depth + 1, newSum);

                place[i] -= nums[depth];
                if(isRenew) {
                    isReach[i] = false;
                }
            }
        }
    }
}

// k = 말의 개수
// n = 2,4,2,4 턴수
// m = 말판의 끝

// n 수 만큼 사람을 뽑고 계산 진행
