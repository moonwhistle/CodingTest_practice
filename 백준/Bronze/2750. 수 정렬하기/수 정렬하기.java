import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            list.add(input.nextInt());
        }

        Collections.sort(list);

        for(int v: list)
        {
            System.out.println(v);
        }


    }
}