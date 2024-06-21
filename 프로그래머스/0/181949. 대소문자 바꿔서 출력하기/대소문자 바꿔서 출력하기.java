import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(char charA : a.toCharArray()){
            if(charA > 90){
                charA -= 32;
                System.out.print(charA);
            }
            else{
                charA += 32;
                System.out.print(charA);
            }
        }
    }
}