import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static Map<String, Integer> genreCount = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution.solution(genres, plays);

        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        List<Music> musicList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            musicList.add(new Music(genres[i], plays[i], i));
        }

        makeGenreCount(musicList);
        Collections.sort(musicList);
        Map<String, Integer> genrePickCount = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        for (Music music : musicList) {
            String genre = music.genre();

            if (genrePickCount.containsKey(genre) && genrePickCount.get(genre) >= 2) {
                continue;
            }

            genrePickCount.put(genre, genrePickCount.getOrDefault(genre, 0) + 1);
            answerList.add(music.index());
        }

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void makeGenreCount(List<Music> musicList) {
        for (Music music : musicList) {
            genreCount.put(music.genre, genreCount.getOrDefault(music.genre, 0) + music.play());
        }
    }

    static class Music implements Comparable<Music> {

        private final String genre;
        private final int play;
        private final int index;

        public Music(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        @Override
        public int compareTo(Music o) {
            if (genreCount.get(this.genre).equals(genreCount.get(o.genre))) {
                return o.play - this.play;
            }

            return genreCount.get(o.genre) - genreCount.get(this.genre);
        }

        public int index() {
            return this.index;
        }

        public int play() {
            return this.play;
        }

        public String genre() {
            return this.genre;
        }
    }
}
