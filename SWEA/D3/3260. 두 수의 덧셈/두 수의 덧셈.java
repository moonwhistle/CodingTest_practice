import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 1; i <= T; i++) {
            String A = input.next();
            String B = input.next();

            if (A.length() < B.length()) {
                String tmp = A;
                A = B;
                B = tmp;
            }

            int[] Aarr = new int[A.length()];
            int[] Barr = new int[B.length()];

            // 숫자로 변환
            for (int j = 0; j < Aarr.length; j++) {
                Aarr[j] = A.charAt(j) - '0';
            }

            for (int j = 0; j < Barr.length; j++) {
                Barr[j] = B.charAt(j) - '0';
            }

            // 계산
            int mod = 0;
            int Aidx = A.length() - 1;

            for (int j = B.length() - 1; j >= 0; j--) {
                int num = Aarr[Aidx] + Barr[j] + mod;
                Aarr[Aidx] = num % 10;
                mod = num / 10;
                Aidx--;
            }

            // 후처리
            if (A.length() > B.length()) {
                while (mod != 0 && Aidx >= 0) {
                    int num = Aarr[Aidx] + mod;
                    Aarr[Aidx] = num % 10;
                    mod = num / 10;
                    Aidx--;
                }
            }

            // 결과
            StringBuilder builder = new StringBuilder();

            if (mod != 0) {
                builder.append(mod);
            }

            for (int a : Aarr) {
                builder.append(a);
            }

            System.out.println("#" + i + " " + builder);
        }
    }
}
