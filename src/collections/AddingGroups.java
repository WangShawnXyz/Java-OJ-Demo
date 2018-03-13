package collections;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args){
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer[] moreInts = {7, 8, 9};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14);
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(16, 17, 18);
        list.set(1, 99);

        for (Integer i: collection) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer i: list) {
            System.out.print( i + " ");
        }
        System.out.println();
    }
}
