import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Set<String> words = new HashSet<>();

        for(int i = 0 ; i< N; i++) {
            words.add(input.next());
        }

        List<Word> words1 = new ArrayList<>();
        for(String word : words) {
            words1.add(new Word(word));
        }

        Collections.sort(words1);
        for(Word word : words1) {
            System.out.println(word.word);
        }
    }
}

class Word implements Comparable<Word> {

    String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(Word other) {
        if (other.word.length() == word.length()) {
            return word.compareTo(other.word);
        }

        return word.length() - other.word.length();
    }
}
