package HeadFirstOffer;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if (array.length < 1) return new ArrayList<>();
        int i = 0, j = array.length-1;
        for (; array[i] + array[j] != sum && i <= j;){
            int tmp = array[i] + array[j];
            if(tmp > sum) j--;
            else i ++;
        }
        if (i > j){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(array[i]);
        result.add(array[j]);
        return result;
    }
    public static void main(String[] args){
        int[] input = {};
        int sum = 10;
        System.out.println(FindNumbersWithSum(input, sum));
    }
}