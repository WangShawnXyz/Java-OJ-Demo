package newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueInteger {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Integer n = in.nextInt();
        String s = n.toString();
        StringBuilder sb = new StringBuilder("");
        for (int i = s.length()-1; i >= 0; i --){
            if (!map.containsKey(s.charAt(i))){
                sb.append(s.charAt(i));
                map.put(s.charAt(i), 1);
            }
        }
        System.out.println(sb.toString());
    }
}
