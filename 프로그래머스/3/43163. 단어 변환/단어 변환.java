import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!isExist(words, target)) {
            return 0;
        }

        boolean[] visited = new boolean[words.length];
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(new Node(begin, 0));

        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();

            if (Objects.equals(poll.word, target)) {
                answer = poll.count;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && differenceCount(poll.word, words[i]) == 1) {
                    visited[i] = true;
                    nodes.add(new Node(words[i], poll.count + 1));
                }
            }
        }

        return answer;
    }

    private boolean isExist(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }

        return false;
    }

    private int differenceCount(String begin, String word) {
        int cnt = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }
}

class Node {

    String word;
    int count;

    public Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
