package newcoder.huawei;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ReSortString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
//        String string = "eeefgghhh";
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < string.length(); i ++){
            if (map.containsKey(string.charAt(i))){
                map.put(string.charAt(i), map.get(string.charAt(i))+1);
            }else{
                map.put(string.charAt(i), 1);
            }
        }
        StringBuilder sb = new StringBuilder(string.length());
//        System.out.println(map.toString());
        while (sb.length() != string.length()){
            for (Map.Entry e : map.entrySet()){
                if ((int)e.getValue() > 0){
                    sb.append(e.getKey());
                    map.put((char)e.getKey(), map.get(e.getKey())-1);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
