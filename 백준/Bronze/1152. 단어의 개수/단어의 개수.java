import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();

        List<String> lineList = List.of(line.split(" "));

        int count = 0;

        for(String word: lineList) {
            if(!Objects.equals(word, "")) {
                count++;
            }
        }

        System.out.println(count);
    }
}
