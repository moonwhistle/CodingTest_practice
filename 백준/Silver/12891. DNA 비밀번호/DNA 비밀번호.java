import java.util.Scanner;

public class Main {

    static int passwordCount = 0;
    static int A;
    static int C;
    static int G;
    static int T;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int S = input.nextInt();
        int P = input.nextInt();
        String given = input.next();
        char[] DNA = given.toCharArray();

        A = input.nextInt();
        C = input.nextInt();
        G = input.nextInt();
        T = input.nextInt();

        //세팅
        int[] setting = new int[4];
        for (int i = 0; i < P; i++) {
            addDNA(setting, DNA[i]);
        }
        countPassword(setting);

        for (int i = P; i < S; i++) {
            addDNA(setting, DNA[i]);
            removeDNA(setting, DNA[i-P]);

            countPassword(setting);
        }

        System.out.println(passwordCount);
    }

    private static void addDNA(int[] setting, char DNA) {
        if (DNA == 'A') {
            setting[0]++;
        }
        if (DNA == 'C') {
            setting[1]++;
        }
        if (DNA == 'G') {
            setting[2]++;
        }
        if (DNA == 'T') {
            setting[3]++;
        }
    }

    private static void removeDNA(int[] setting, char DNA) {
        if (DNA == 'A') {
            setting[0]--;
        }
        if (DNA == 'C') {
            setting[1]--;
        }
        if (DNA == 'G') {
            setting[2]--;
        }
        if (DNA == 'T') {
            setting[3]--;
        }
    }

    private static void countPassword(int[] setting) {
        if (setting[0] >= A && setting[1] >= C && setting[2] >= G && setting[3] >= T) {
            passwordCount++;
        }
    }
}
