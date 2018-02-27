package newcoder;

import java.util.Scanner;

public class ReversedString {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i --){
            reversed.append(s.charAt(i));

        }
        System.out.println(reversed.toString());
    }
}
