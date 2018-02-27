package newcoder;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MergeTableRecord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i ++){
//            String s = sc.nextLine();
//            String[] strings =  s.split(" ");
            Integer key = sc.nextInt();
            Integer value = sc.nextInt();
            if (treeMap.containsKey(key)){
                treeMap.put(key, treeMap.get(key) + value);
            }else {
                treeMap.put(key, value);
            }
        }
        for (Map.Entry<Integer, Integer> e: treeMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        sc.close();
    }
}
