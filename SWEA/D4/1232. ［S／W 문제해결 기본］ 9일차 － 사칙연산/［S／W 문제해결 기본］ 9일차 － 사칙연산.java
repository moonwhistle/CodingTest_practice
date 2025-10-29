import java.util.Objects;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int size = input.nextInt();
            input.nextLine();

            Node[] nodes = new Node[size + 1];

            for (int j = 0; j < size; j++) {
                String line = input.nextLine();
                String[] lineElements = line.split(" ");

                if (lineElements.length == 2) {
                    nodes[Integer.parseInt(lineElements[0])] = new Node(lineElements[1], null, null);
                } else {
                    nodes[Integer.parseInt(lineElements[0])] = new Node(lineElements[1],
                            Integer.parseInt(lineElements[2]), Integer.parseInt(lineElements[3]));
                }
            }

            int answer = inorder(1, nodes);

            System.out.println("#" + i+ " " + answer);
        }
    }

    private static int inorder(int start, Node[] nodes) {
        Node now = nodes[start];

        if (now.left() == null && now.right() == null) {
            return Integer.parseInt(now.value());
        }

        int left = inorder(now.left(), nodes);
        int right = inorder(now.right(), nodes);

        if (Objects.equals(now.value(), "+")) {
            return left + right;
        } else if (Objects.equals(now.value(), "-")) {
            return left - right;
        } else if (Objects.equals(now.value(), "*")) {
            return left * right;
        } else {
            return left / right;
        }
    }
}

class Node {

    private final String value;
    private final Integer left;
    private final Integer right;

    Node(String value, Integer left, Integer right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String value() {
        return value;
    }

    public Integer left() {
        return this.left;
    }

    public Integer right() {
        return this.right;
    }
}
