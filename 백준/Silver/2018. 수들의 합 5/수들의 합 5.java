import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        int cnt = 1;

        for (int i = 0; i < N-1; i++) {
            int sum = numbers[i];

            for(int j = i + 1; j<N; j++){
                sum += numbers[j];

                if(sum > N) {
                    break;
                }
                if(sum == N) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
