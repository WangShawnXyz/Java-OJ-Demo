package newcoder.huawei;

import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Integer integer = in.nextInt();
        String iStr = integer.toString();
        StringBuilder reversed = new StringBuilder();
        for (int i = iStr.length()-1; i >= 0; i --){
            reversed.append(iStr.charAt(i));
        }
        System.out.println(reversed.toString());
    }
}
