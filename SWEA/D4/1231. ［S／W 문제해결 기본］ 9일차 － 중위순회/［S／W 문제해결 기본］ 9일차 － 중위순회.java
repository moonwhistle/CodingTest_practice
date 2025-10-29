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

                if (lineElements.length == 3) {
                    nodes[Integer.parseInt(lineElements[0])] = new Node(lineElements[1],
                            Integer.parseInt(lineElements[2]), null);
                } else if (lineElements.length == 4) {
                    nodes[Integer.parseInt(lineElements[0])] = new Node(lineElements[1],
                            Integer.parseInt(lineElements[2]), Integer.parseInt(lineElements[3]));
                } else {
                    nodes[Integer.parseInt(lineElements[0])] = new Node(lineElements[1], null, null);
                }
            }

            System.out.print("#" + i + " ");
            inorder(1, nodes);
            System.out.println();
        }

    }

    private static void inorder(Integer index, Node[] nodes) {
        if (index == null) {
            return;
        }
        Node now = nodes[index];
        inorder(now.left, nodes);
        System.out.print(now.word);
        inorder(now.right, nodes);
    }
}

class Node {

    String word;
    Integer left;
    Integer right;

    public Node(String word, Integer left, Integer right) {
        this.word = word;
        this.left = left;
        this.right = right;
    }
}
