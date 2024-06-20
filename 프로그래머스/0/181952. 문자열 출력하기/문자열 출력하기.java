import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if(a.length()<0 && a.length()>1000000){
            a = sc.next();
        }
        System.out.println(a);
    }
}