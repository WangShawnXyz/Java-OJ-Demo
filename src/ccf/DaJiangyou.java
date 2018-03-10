package ccf;

import java.util.Scanner;

public class DaJiangyou {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int bottle = money / 10;
        int result = bottle;
        result = bottle + bottle/5*2;
        bottle %= 5;
        if (bottle >= 3){
            result += 1;
        }
        System.out.println(result);
    }
}
