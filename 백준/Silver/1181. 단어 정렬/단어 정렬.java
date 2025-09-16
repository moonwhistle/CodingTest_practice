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
        Set<String> wordsSet = new HashSet<>();
        List<Word> words = new ArrayList<>();

        // 중복 단어 제거
        for (int i = 0; i < N; i++) {
            wordsSet.add(input.next());
        }

        for(String word : wordsSet) {
            words.add(new Word(word));
        }

        Collections.sort(words);
        
        for(Word word : words) {
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
        if(word.length() != other.word.length()) {
            return word.length() - other.word.length();
        } else {
            return word.compareTo(other.word);
        }
    }
}
