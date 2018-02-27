package newcoder;


import java.util.Scanner;

public class AsciiCounter {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
        String s = "uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx";
        int counter = 0;
        int[] flag = new int[128];
        for (int i = 0; i < s.length(); i ++){
            int rank = (int)s.charAt(i);
            if (0 <= rank && rank <= 127){
                flag[rank] ++;
            }
        }
        for (int i : flag){
            if (i >0 ){
                counter ++;
            }
        }
        System.out.println(counter);
    }

}
