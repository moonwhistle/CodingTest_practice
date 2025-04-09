import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        String delimiter = input.next();
        String[] elements = delimiter.split("\\*");

        StringBuilder pattern = new StringBuilder("^" + elements[0] + ".*");
        for(int i = 1; i< elements.length -1 ; i++) {
            pattern.append(elements[i]).append(".*");
        }
        pattern.append(elements[elements.length -1]).append("$");
        
        for(int i = 0; i<N; i++) {
            String in = input.next();
            if(Pattern.matches(String.valueOf(pattern), in)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

    }
}
