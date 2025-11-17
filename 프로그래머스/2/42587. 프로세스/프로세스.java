import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Process> prioprityQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
            prioprityQueue.add(new Process(priorities[i], i));
        }

        int count = 1;

        while (!prioprityQueue.isEmpty()) {
            Process poll = prioprityQueue.poll();

            if (poll.priority() == queue.peek()) {
                if (poll.sequence() == location) {
                    answer = count;
                    break;
                } else {
                    queue.poll();
                    count++;
                }
            } else {
                prioprityQueue.add(poll);
            }
        }

        return answer;
    }
}

class Process {

    private final int priority;
    private final int sequence;

    Process(int priority, int sequence) {
        this.priority = priority;
        this.sequence = sequence;
    }

    public int priority() {
        return this.priority;
    }

    public int sequence() {
        return this.sequence;
    }
}
